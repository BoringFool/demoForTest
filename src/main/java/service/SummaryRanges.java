package service;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class SummaryRanges {
    private Node head;
    private Node tail;

    public SummaryRanges() {
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.next = tail;
    }

    public void addNum(int value) {
        if (head.next.next == null) {
            int[] arr = {value, value};
            head.next = new Node(arr, head, tail);
            tail.pre = head.next;
            return;
        }

        Node hi = tail.pre;
        while (hi.pre != null) {
            int[] hiArr = hi.intervals;

            if (value >= hiArr[0] && value <= hiArr[1]) {
                return;
            }

            if (value > hiArr[1]) {
                if (value == hiArr[1] + 1) {
                    hiArr[1] = value;
                } else {
                    int[] arr = {value, value};
                    Node t = hi.next;
                    hi.next = new Node(arr, hi, t);
                    t.pre = hi.next;
                }

                return;
            }

            hi = hi.pre;

        }

        Node t = head.next;
        if (value == t.intervals[0] - 1) {
            t.intervals[0] = value;
        } else {
            int[] arr = {value, value};
            head.next = new Node(arr, head, t);
            t.pre = head.next;
        }
    }

    public int[][] getIntervals() {
        return get(merge());
    }

    private int merge() {
        Node cur = head.next;
        int len = 0;

        while (cur.next != null) {
            Node next = cur.next;
            if (next.next == null) {
                len++;
                break;
            }

            if (cur.intervals[1] == next.intervals[0] - 1) {
                cur.intervals = new int[]{cur.intervals[0], next.intervals[1]};

                //移除被融合节点
                Node n = next.next;
                cur.next = n;
                n.pre = cur;
            } else {
                len++;
                cur = cur.next;
            }
        }

        return len;
    }

    private int[][] get(int len) {
        if (len == 0) {
            return new int[][]{};
        }

        int[][] ans = new int[len][2];
        Node cur = head.next;
        int i = 0;

        while (cur.next != null) {
            ans[i] = cur.intervals;
            cur = cur.next;
            i++;
        }

        return ans;
    }

    static class Node {
        int[] intervals;
        Node pre;
        Node next;

        public Node() {

        }

        public Node(int[] intervals, Node pre, Node next) {
            this.intervals = intervals;
            this.pre = pre;
            this.next = next;
        }

        public int[][] toArray(int len) {
            int[][] arr = new int[len][2];

            return arr;
        }

    }
}
