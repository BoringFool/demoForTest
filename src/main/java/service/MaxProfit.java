package service;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int ans = 0, cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (cur > prices[i]) {
                cur = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - cur);
            }
        }

        return ans;
    }

    public int maxProfit_II(int[] prices) {
        int ans = 0, cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (cur <= prices[i]) {
                ans += prices[i] - cur;
            }

            cur = prices[i];
        }

        return ans;
    }

    public int maxProfit_III(int[] prices) {
        int i = 0, n = prices.length - 1;
        int[] fromStart = new int[prices.length];
        int maxStart = prices[i], minStart = prices[i];
        i++;
        int[] fromEnd = new int[prices.length];
        int maxEnd = prices[n], minEnd = prices[n];
        n--;

        while (n >= 0) {
            //正向
            fromStart[i] = fromStart[i - 1];
            if (prices[i] <= minStart) {
                maxStart = minStart = prices[i];
            }

            if (prices[i] > maxStart) {
                maxStart = prices[i];
                fromStart[i] = Math.max(maxStart - minStart, fromStart[i]);
            }
            i++;

            //逆向
            fromEnd[n] = fromEnd[n + 1];
            if (prices[n] < minEnd) {
                minEnd = prices[n];
                fromEnd[n] = Math.max(maxEnd - minEnd, fromEnd[n]);
            }

            if (prices[n] >= maxEnd) {
                maxEnd = minEnd = prices[n];
            }
            n--;
        }

        i = 0;
        int ans = fromStart[prices.length - 1];
        while (i < prices.length - 1) {
            ans = Math.max(ans, fromStart[i] + fromEnd[i + 1]);
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{3, 3, 5, 0, 0, 3, 1, 4}; // 6
        int[] a = new int[]{1, 2, 3, 4, 5}; // 4
//        int[] a = new int[]{7,6,4,3,1}; // 0
//        int[] a = new int[]{1}; //0
//        int[] a = new int[]{1,2,4,2,5,7,2,4,9,0}; //13
//        int[] a = new int[]{2,1,2,1,0,0,1}; //2
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.maxProfit_III(a));
    }
}
