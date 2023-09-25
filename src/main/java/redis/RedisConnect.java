package redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.params.SetParams;
import redis.clients.jedis.resps.ScanResult;
import redis.clients.jedis.resps.Tuple;

import java.util.*;


public class RedisConnect {
    private static final Logger log = LoggerFactory.getLogger(RedisConnect.class);
    private static final JedisCluster JC = RedisClusterUtil.getJedis();
    private static final Jedis J = new Jedis("192.168.128.103", 7001);

    public void testRedis() {
//        J.auth("804998");
        String pong = J.ping();
        log.info(pong);
        J.get("name");
        log.info(J.get("name"));
    }

    public void testClusterString() {
        SetParams sp = new SetParams();
        sp.ex(30).nx();

        JC.set("{testStringSet}a", "anythinga", sp);
        JC.set("{testStringSet}b", "anythingb", sp);
        JC.set("{testStringSet}c", "anythingc", sp);
        JC.set("{testStringSet}d", "anythingd", sp);
        JC.set("{testStringSet}e", "anythinge", sp);
        JC.set("{testStringSet}f", "anythinggg", sp);
        JC.mset("{testStringSet}m1", "m1", "{testStringSet}m2", "");
        String s = JC.get("{testStringSet}m1");
        log.info(s);
        s = JC.get("{testStringSet}m2");
        log.info(s);
    }

    public void testClusterStringScan() {
        ScanParams sp = new ScanParams();
        sp.match("{testStringSet}*");
        sp.count(10);
        List<String> l = new ArrayList<>();

        for (ScanResult<String> sr; ; ) {
            sr = JC.scan("0", sp);
            l.addAll(sr.getResult());
            if ("0".equals(sr.getCursor())) {
                break;
            }
        }

        log.info(l.toString());
    }

    public void testClusterSortedSet() {
        JC.zadd("{testSortedSet}", 0,"one");
        JC.zadd("{testSortedSet}", 1,"one");
        JC.zadd("{testSortedSet}", 1,"two");
        JC.zadd("{testSortedSet}", 2,"three");
        JC.zadd("{testSortedSet}", 3,"four");

        JC.zrem("{testSortedSet}", "three");

        List<String> list =  JC.zrange("{testSortedSet}", 0, -1);
        log.info(list.toString());

        log.info("score:{}" ,JC.zscore("{testSortedSet}", "four"));
        log.info("incrby:{}" ,JC.zincrby("{testSortedSet}", 7, "four"));
        log.info("score:{}" ,JC.zscore("{testSortedSet}", "four"));
        log.info("card:{}" ,JC.zcard("{testSortedSet}"));
        log.info("count:{}" ,JC.zcount("{testSortedSet}", 0, 10));
        log.info("rank:{}" ,JC.zrank("{testSortedSet}", "one"));
        Tuple t = JC.zpopmin("{testSortedSet}");
        log.info("popmin: element-{}; score-{}" , t.getElement(), t.getScore());
        list =  JC.zrange("{testSortedSet}", 0, -1);
        log.info(list.toString());

    }

    public void testClusterHash() {
        JC.hset("hashKey", "one", "1");
        Map<String, String> map = new HashMap<>();
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        JC.hset("hashKey", map);

        log.info("exist:{}", JC.hexists("hashKey", "three"));
        JC.hdel("hashKey", "three", "four");
        log.info("exist:{}", JC.hexists("hashKey", "three"));
        log.info("length:{}", JC.hlen("hashKey"));
        log.info("StringLength:{}", JC.hstrlen("hashKey", "one"));
        JC.hmset("hashKey", map);
        log.info("multiGet:{}", JC.hmget("hashKey", "one", "two").toString());
        log.info("length:{}", JC.hlen("hashKey"));
        log.info("keys:{}", JC.hkeys("hashKey").toString());
        log.info("vals:{}", JC.hvals("hashKey").toString());
        log.info("all:{}", JC.hgetAll("hashKey").toString());

    }


    public void testClusterList() {
        JC.lpush("list-jedis", "element-1", "element-2", "element-3");

        long len = JC.llen("list-jedis");
        log.info("长度：" + len);

        List<String> list = JC.lrange("list-jedis", 0, -1);
        log.info(list.toString());

        JC.ltrim("list-jedis", 1, len);
        list = JC.lrange("list-jedis", 0, -1);
        log.info(list.toString());

        JC.lrem("list-jedis", -1, "element-1");
        list = JC.lrange("list-jedis", 0, -1);
        log.info(list.toString());

        JC.rpush("list-jedis", "element-4", "element-5", "element-6");
        list = JC.lrange("list-jedis", 0, -1);
        log.info(list.toString());

        String s = JC.rpop("list-jedis");
        log.info(s);
        s = JC.lpop("list-jedis");
        log.info(s);
        list = JC.lrange("list-jedis", 0, -1);
        log.info(list.toString());
    }

    public void testClusterSet() {
        JC.sadd("{setTest}", "无序", "去重", "去重", "对比无重复的两个数据集", "可以交集，并集，差集");
        JC.sadd("{setTest}1", "无序", "去重", "去重", "对比无重复的两个数据集", "可以交集，并集，差集");
        JC.sadd("{setTest}2", "无序", "去重", "去重", "对比无重复的两个数据集", "差集");

        Set<String> result = JC.smembers("{setTest}");
        log.info(result.toString());
        log.info(String.valueOf(JC.sismember("{setTest}", "无需")));
        log.info(String.valueOf(JC.sismember("{setTest}", "无序")));
        log.info("------------------");
        result = JC.sdiff("{setTest}", "{setTest}1");
        log.info(result.toString());
        result = JC.sdiff("{setTest}", "{setTest}2");
        log.info(result.toString());
        log.info(JC.srandmember("{setTest}"));
        log.info(JC.spop("{setTest}"));
        log.info("------------------");
        result = JC.smembers("{setTest}");
        log.info(result.toString());
        JC.srem("{setTest}2", "对比无重复的两个数据集", "差集");
        result = JC.smembers("{setTest}2");
        log.info(result.toString());
    }

    public void delAllKey() {
        String[] s = {"{testStringSet}a", "{testStringSet}b", "{testStringSet}c", "{testStringSet}d",
                "{testStringSet}e", "{testStringSet}f", "{testStringSet}m1", "{testStringSet}m2",
                "list-jedis", "{setTest}", "{setTest}1", "{setTest}2", "{testSortedSet}", "hashKey"};

        Arrays.stream(s).forEach(JC::del);
    }
}
