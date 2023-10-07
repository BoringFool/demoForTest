package service;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    private final Node tail = new Node();
    private final Deque<int[]> q;

    public StockSpanner() {
        q = new ArrayDeque<int[]>();
    }

    public int next(int price) {
        Node cur = new Node(price);
        Node pre = tail.pre;

        tail.pre = cur;
        if (pre == null) {
            cur.span = 1;
            return 1;
        }

        if (price < pre.val) {
            cur.span = 1;
        } else {
            int cnt = pre.span;
            while ((pre = pre.pre) != null && price >= pre.val) {
                cnt += pre.span;
            }

            cur.span = cnt + 1;
        }

        cur.pre = pre;
        return cur.span;
    }

    /**
     * 单调站栈实现
     *
     * @param price
     * @return
     */
    public int next_I(int price) {
        int cnt = 0;
        int[] cur ;
        while ((cur = q.peek()) != null && cur[0] <= price) {
            q.poll();
            cnt += cur[1];
        }

        q.push(new int[]{price, ++cnt});
        return cnt;
    }

    private static class Node {
        int val;
        int span;
        Node pre;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next_I(100));
        System.out.println(stockSpanner.next_I(80));
        System.out.println(stockSpanner.next_I(60));
        System.out.println(stockSpanner.next_I(70));
        System.out.println(stockSpanner.next_I(60));
        System.out.println(stockSpanner.next_I(75));
        System.out.println(stockSpanner.next_I(85));
    }
}
