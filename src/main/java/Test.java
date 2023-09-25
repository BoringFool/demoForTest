import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class Test {
    private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<>();

    class Node{
        Node prev;
        Node next;
        Integer key;
        int value;

        Node(Node prev, Node next, Integer key, int value){
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }

    }
    public static void main(String[] args) {
        Long.toBinaryString(-112l);

        Scanner in = new Scanner(System.in);
        int cache = in.nextInt();

        Test m = new Test();
        Test.Node head = m.new Node(null, null, null, 0);
        Test.Node tail = m.new Node(null, null, null, 0);

        Map<Integer, Test.Node> map = new HashMap<>();
        int len = 0;

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String op = in.next();
            int key = in.nextInt();
            int val = 0;
            if("p".equals(op)){
                val = in.nextInt();
            }

            if("p".equals(op)){
                Test.Node temp = map.get(key);
                if(temp == null){
                    if(len == 0){//第一次插入
                        head.next = tail.prev = m.new Node(head, tail, key, val);
                        map.put(key, head.next);
                        len++;
                        continue;
                    }else if(len >= cache){//超出开始删除尾部
                        map.remove(tail.prev.key);
                        tail.prev.next = null;
                        tail.prev = tail.prev.prev;
                        tail.prev.next.prev = null;
                        tail.prev.next = tail;
                        len--;
                    }

                    head.next = m.new Node(head, head.next, key, val);
                    head.next.next.prev = head.next;

                    map.put(key, head.next);
                    len++;
                }else{
                    temp.value = val;
                }
            }else{
                Test.Node temp = map.get(key);
                if(temp == null){
                    System.out.println(-1);
                }else{
                    //刷新使用
                    if(len > 1){
                        if(temp != head.next){
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                            temp.prev = head;
                            temp.next = head.next;
                            head.next.prev = temp;
                            head.next = temp;
                        }
                        // if(temp == tail.prev){//最后一个
                        //     tail.prev = temp.prev;
                        //     temp.prev.next = tail;
                        //     temp.prev = head;
                        //     temp.next = head.next;
                        //     head.next.prev = temp;
                        //     head.next = temp;
                        // }else if(temp != head.next){//中间节点
                        //     temp.prev.next = temp.next;
                        //     temp.next.prev = temp.prev;
                        //     temp.prev = head;
                        //     temp.next = head.next;
                        //     head.next.prev = temp;
                        //     head.next = temp;
                        // }
                    }
                    //头节点不处理
                    System.out.println(temp.value);
                }

            }
        }
//        ExecutorService excutor = Executors.newFixedThreadPool(10);
////        for (int i = 0; i < 100; i++) {
////            excutor.submit(new DateUtil("2019-11-25 09:00:" + i % 60));
////        }
//
//        excutor.execute(new DateUtil("2019-11-25 09:00:00"));
//
//        try {
//            Thread.sleep(1500);
//            excutor.shutdown();
//            if(!excutor.awaitTermination(3, TimeUnit.SECONDS)){
//                excutor.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            System.out.println("out e");
//            throw new RuntimeException(e);
//        }
    }

    static class DateUtil implements Runnable {
        private String date;

        public DateUtil(String date) {
            this.date = date;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name);
            SleepClass sc = new SleepClass();
            try {
                sc.sleep();
            } catch (InterruptedException e) {
                System.out.println("out e");
                throw new RuntimeException(e);
            }
//            if (local.get() == null) {
//                local.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//                System.out.println(name + "-----------------------" + date);
//            } else {
//                try {
//                    Date date = local.get().parse(this.date);
//                    System.out.println(name + ":" + date);
//                } catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
    }



//    public static void main(String[] args) {
////        System.out.println("group:" + Thread.currentThread().getThreadGroup().getMaxPriority());
////        ConcurrentSkipListMap
//
//
//
//
//
//
//
//
////        Test test = new Test();
////        ListNode l1 = test.new ListNode(1);
////        ListNode l2 = test.new ListNode(1);
////
////        ListNode l3 = l1;
////        ListNode l4 = l2;
////
////        l1.next = test.new ListNode(2);
////        l1 = l1.next;
////        l1.next = test.new ListNode(4);
//////        l1 = l1.next;
//////        l1.next = test.new ListNode(5);
//////        l1 = l1.next;
//////        l1.next = test.new ListNode(6);
//////        l1 = l1.next;
//////        l1.next = test.new ListNode(8);
//////        l1 = l1.next;
//////        l1.next = test.new ListNode(3);
//////        l1 = l1.next;
//////        l1.next = test.new ListNode(5);
//////        l1 = l1.next;
//////        l1.next = test.new ListNode(7);
////
////        l2.next = test.new ListNode(3);
////        l2 = l2.next;
////        l2.next = test.new ListNode(4);
//////        l2 = l2.next;
//////        l2.next = test.new ListNode(0);
//////        l2 = l2.next;
//////        l2.next = test.new ListNode(8);
//////        l2 = l2.next;
//////        l2.next = test.new ListNode(5);
//////        l2 = l2.next;
//////        l2.next = test.new ListNode(8);
//////        l2 = l2.next;
//////        l2.next = test.new ListNode(9);
//////        l2 = l2.next;
//////        l2.next = test.new ListNode(7);
////
////
////        test.mergeTwoLists(l3, l4);
//    }


//    static <K,V> HashMap.TreeNode<K,V> balanceInsertion(HashMap.TreeNode<K,V> root,
//                                                        HashMap.TreeNode<K,V> x) {
//        //当前节点设为红
//        x.red = true;
//        //迭代判断是否需要旋转染色
//        for (HashMap.TreeNode<K,V> xp, xpp, xppl, xppr;;) {
////            获取父节点，如果没有父节点说明是根节点，设为黑色，返回根节点
//            if ((xp = x.parent) == null) {
//                x.red = false;
//                return x;
//            }
////            父节点为黑色，或者祖父节点是根节点，当前节点为红不用处理，返回根节点。
//            else if (!xp.red || (xpp = xp.parent) == null)
//                return root;
//            //判断父节点是祖父节点的左子树还是右子树
//            //父节点是红色
//            if (xp == (xppl = xpp.left)) {//左子树
//                //叔节点是红色，进行染色，不旋转
//                if ((xppr = xpp.right) != null && xppr.red) {
//                    xppr.red = false;//叔节点设为黑色
//                    xp.red = false;//父节点设为黑色
//                    xpp.red = true;//祖父节点设为红色
//                    x = xpp;//对祖父节点进行平衡判断
//                }
//                else {
//                    //叔节点是黑节点
//                    //判断当前节点，是否是父节点的右节点
//                    if (x == xp.right) {//右节点
//                        root = rotateLeft(root, x = xp);//对父节点左旋
//                        xpp = (xp = x.parent) == null ? null : xp.parent;//获取祖父节点
//                    }
//                    if (xp != null) {//原右节点不为空
//                        xp.red = false;//原右节点染黑
//                        if (xpp != null) {//存在祖父节点
//                            xpp.red = true;//祖父节点染红
//                            root = rotateRight(root, xpp);
//                        }
//                    }
//                }
//            }
//            else {//右子树
//                //叔节点是红色，进行染色，不旋转
//                if (xppl != null && xppl.red) {
//                    xppl.red = false;//叔节点设为黑色
//                    xp.red = false;//父节点设为黑色
//                    xpp.red = true;//祖父节点设为红色
//                    x = xpp;//对祖父节点再次进行平衡判断
//                }
//                else {
//                    if (x == xp.left) {
//                        root = rotateRight(root, x = xp);
//                        xpp = (xp = x.parent) == null ? null : xp.parent;
//                    }
//                    if (xp != null) {
//                        xp.red = false;
//                        if (xpp != null) {
//                            xpp.red = true;
//                            root = rotateLeft(root, xpp);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//    static <K,V> HashMap.TreeNode<K,V> rotateLeft(HashMap.TreeNode<K,V> root, HashMap.TreeNode<K,V> p) {
//        HashMap.TreeNode<K,V> r, pp, rl;
//        //当前节点，右节点，非空判断
//        if (p != null && (r = p.right) != null) {
//            if ((rl = p.right = r.left) != null)//右节点的左子节点转移到当前节点的右节点；
//                rl.parent = p;//右节点的左节点存在，需要设置其父节点为当前节点
//            if ((pp = r.parent = p.parent) == null)//右子节点指向祖父节点；同时判断，祖父节点是否为空
//                (root = r).red = false;//右节点设为根节点，染黑色
//            else if (pp.left == p)//当前节点是父节点的左节点
//                pp.left = r;//祖父节点的左节点指向当前节点的右节点
//            else//当前节点是父节点的右节点
//                pp.right = r;//祖父节点的右节点指向当前节点的右节点
//            r.left = p;//当前节点转移到右节点左节点
//            p.parent = r;//当前节的原右节点设为当前节点的父节点
//        }
//        return root;
//    }
//
//    static <K,V> HashMap.TreeNode<K,V> rotateRight(HashMap.TreeNode<K,V> root, HashMap.TreeNode<K,V> p) {
//        HashMap.TreeNode<K,V> l, pp, lr;
//        if (p != null && (l = p.left) != null) {//当前节点，左节点，非空判断
//            if ((lr = p.left = l.right) != null)//是否存在右节点
//                lr.parent = p;//左节点的右节点指向父节点
//            if ((pp = l.parent = p.parent) == null)//判断是否存在祖父节点
//                (root = l).red = false;//不存在，则当前节点设为根节点，染黑
//            else if (pp.right == p)//父节点是祖父节点的右节点
//                pp.right = l;//祖父节点右节点的左节点指向左节点
//            else
//                pp.left = l;//祖父节点左节点的左节点指向左节点
//            l.right = p;//左节点的右节点指向父节点
//            p.parent = l;
//        }
//        return root;
//    }


}
