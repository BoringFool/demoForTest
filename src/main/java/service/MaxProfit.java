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

    public static void main(String[] args) {
        int[] a = new int[]{6, 7, 2, 8, 1};
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.maxProfit(a));
    }
}
