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

    public static void main(String[] args) {
        int[] a = new int[]{7,1,4,4,25};
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.maxProfit_II(a));
    }
}
