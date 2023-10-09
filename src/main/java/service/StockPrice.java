package service;

import java.util.HashMap;
import java.util.Map;

public class StockPrice {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }

    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    private int cur = 0;

    public StockPrice() {
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        tail.val = Integer.MAX_VALUE;
    }

    public void update(int timestamp, int price) {
        Node temp;
        cur = Math.max(cur, timestamp);

        if (cache.containsKey(timestamp)) {
            temp = cache.get(timestamp);
            if (temp.val == price) {
                return;
            }

            //变小了，向前搜索
            if (temp.val > price) {
                temp.val = price;
                Node pre = temp.pre;
                removeNode(temp);
                addNode(searchToHead(pre, temp), temp);
            } else {
                temp.val = price;
                Node next = temp.next;
                removeNode(temp);
                addNode(searchToTail(next, temp), temp);
            }
        } else {
            temp = new Node();
            temp.val = price;
            cache.put(timestamp, temp);
            addNode(searchToTail(head, temp), temp);
        }
    }

    private Node searchToHead(Node pre, Node node) {
        while (node.val < pre.val) {
            pre = pre.pre;
        }

        return pre;
    }

    private Node searchToTail(Node next, Node node) {
        while (node.val > next.val) {
            next = next.next;
        }

        return next.pre;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private void addNode(Node pre, Node node) {
        pre.next.pre = node;
        node.next = pre.next;
        node.pre = pre;
        pre.next = node;
    }

    public int current() {
        return cache.get(cur).val;
    }

    public int maximum() {
        return tail.pre.val;
    }

    public int minimum() {
        return head.next.val;
    }

    private static class Node {
        int val;
        Node pre;
        Node next;
    }

}
