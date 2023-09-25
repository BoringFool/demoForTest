package service;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private final Map<Integer, Node> cache;
    private final ListNode head;
    private final ListNode tail;

    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.right = this.tail;
        this.tail.left = this.head;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node temp = cache.get(key);
            ListNode location = temp.head;
            temp.fre++;
            int val = temp.val;

            //更新节点位置
            //移出当前节点
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
            //向前移动
            ListNode left = location.left;

            //当前节点空了，移除节点
            if (location.head.next == location.tail) {
                left.right = location.right;
                location.right.left = left;
            }

            //判断temp插入的位置
            addNode(left, temp);
            return val;
        }

        return -1;
    }

    private void addNode(ListNode left, Node temp) {
        ListNode right;
        if (left == head || left.fre > temp.fre) {
            right = left.right;
        } else if (left.fre == temp.fre) {
            right = left;
        } else {
            right = left;
            left = left.left;
        }

        if (left == right) {//已存在节点
            Node t = left.head.next;
            left.head.next = temp;
            temp.pre = left.head;
            temp.next = t;
            t.pre = temp;
            temp.head = left;
        } else {
            ListNode cur = new ListNode(left, right);
            cur.fre = temp.fre;

            //左右连接
            left.right = cur;
            cur.left = left;
            cur.right = right;
            right.left = cur;

            //上下连接
            cur.head = new Node();
            cur.tail = new Node();
            cur.head.next = temp;
            temp.pre = cur.head;
            temp.next = cur.tail;
            cur.tail.pre = temp;
            temp.head = cur;
        }
    }

    public void put(int key, int value) {
        int val = get(key);
        if (val != -1) {//说明存在，且通过get操作，位置已经更新过了，只需要从缓存取到节点，然后更新值就可以了。
            cache.get(key).val = value;
        } else {
            //判断容量，是否需要移除节点
            if (cache.size() == capacity) {
                ListNode last = tail.left;
                Node lastNode = last.tail.pre;

                //移除最近最少使用的，最近最久未使用的节点
                cache.remove(lastNode.key);
                lastNode.pre.next = lastNode.next;
                lastNode.next.pre = lastNode.pre;

                //当前列表节点为空，需要移除当前列表节点
                if (last.head.next == last.tail) {
                    last.left.right = tail;
                    tail.left = last.left;
                }
            }

            //插入节点
            Node temp = new Node(key, value, null, null);
            cache.put(key, temp);
            ListNode left = tail.left;
            //判断左右节点，应该可以和get一起抽出来一个操作方法
            addNode(left, temp);
        }
    }

    private static class ListNode {
        int fre;
        Node head;
        Node tail;
        ListNode left;
        ListNode right;

        public ListNode() {
            this(null, null);
        }

        public ListNode(ListNode left, ListNode right) {
            this.left = left;
            this.right = right;
            this.fre = 1;
        }

    }

    private static class Node {
        int key;
        int val;
        int fre;
        Node pre;
        Node next;
        ListNode head;

        public Node() {
            this(-1, -1, null, null);
        }

        public Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
            this.fre = 1;
        }
    }
}
