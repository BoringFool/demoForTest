package service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    private final int capacity;
    private int length;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node temp = cache.get(key);
            moveNode(temp);
            return temp.val;
        }

        return -1;
    }

    private void moveNode(Node temp) {
        //移除原有位置
        Node pre = temp.pre;
        Node next = temp.next;
        pre.next = next;
        next.pre = pre;

        //复用一下变量next
        next = head.next;
        //插入到头部
        head.next = temp;
        temp.pre = head;
        temp.next = next;
        next.pre = temp;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node temp = cache.get(key);
            temp.val = value;

            moveNode(temp);
            return;
        }

        //当前容量已满，移除最后一个
        if (length == capacity) {
            Node temp = tail.pre;
            temp.pre.next = tail;
            tail.pre = temp.pre;
            cache.remove(temp.key);
            length--;
        }

        length++;
        Node next = head.next;
        head.next = new Node(key, value, head, next);
        next.pre = head.next;
        cache.put(key, head.next);
    }

    private static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node() {
            this.key = -1;
            this.val = -1;
            this.pre = null;
            this.next = null;
        }

        public Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

    }

}
