package redis;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class RedisConnectTest {
    private static final Logger log = LoggerFactory.getLogger(RedisConnectTest.class);
    RedisConnect redisConnect = new RedisConnect();
    static RedisConnectTest redisConnectTest = new RedisConnectTest();

    @BeforeAll
    static void beforeAll() {
        log.info("START:{}", System.currentTimeMillis());
    }

    @AfterAll
    static void afterAll() {
        redisConnectTest.delAllKey();
        log.info("END:{}", System.currentTimeMillis());
    }

    @Test
    void testRedis() {
        log.info("testRedis");
        redisConnect.testRedis();

    }

    @Test
    void testClusterString() {
        log.info("testClusterString");
        redisConnect.testClusterString();

    }

    @Test
    void testClusterStringScan() {
        log.info("testClusterStringScan");
        redisConnect.testClusterStringScan();

    }

    @Test
    void testClusterSortedSet() {
        log.info("testClusterSortedSet");
        redisConnect.testClusterSortedSet();

    }

    @Test
    void testClusterHash() {
        log.info("testClusterHash");
        redisConnect.testClusterHash();

    }

    @Test
    void testClusterList() {
        log.info("testClusterList");
        redisConnect.testClusterList();

    }

    @Test
    void testClusterSet() {
        log.info("testClusterSet");
        redisConnect.testClusterSet();

    }


    private void delAllKey() {
        log.info("delAllKey");
        redisConnect.delAllKey();
    }

    /**
     * 手动格式化时间
     */
    @BeforeEach
    void methodStartTime() {
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, zone);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String localTime = df.format(ldt);

        log.info("-------START-------{}",  localTime);
    }

    /**
     * 日志自动格式化时间
     */
    @AfterEach
    void methodEndTime() {
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, zone);

        log.info("-------END-------{}", ldt);//这样也是一样的时间格式输出到日志
    }
}
