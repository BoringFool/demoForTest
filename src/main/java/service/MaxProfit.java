package service;

import java.util.Arrays;

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

    public int maxProfit_IV(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }

    /**
     * 卖出后会有一天冷静期
     * 每天有三种状态：
     * 买入/持有：昨天（i-1）已经买入过了的累计收益，或者前一天（i-2）卖出减去当天买
     * 入支出的累计收益，取最大值。
     * 卖出：昨天的买入最大累计收益加上当天卖出所得。对比昨天的卖出收益
     * 什么都不做：和昨天一样。买入卖出都和昨天对比过了
     *
     * @param prices
     * @return
     */
    public int maxProfit_V(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//第一天买入，收益为负
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], dp[0][1] - prices[1]);//记录两天内买入的最小花费
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);//卖出则第一天必须买入，计算所得累计收益。

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 2][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }

        //最有一天的持有无法卖出，必定比最后一天的卖出小，所以不必考虑。
        return dp[prices.length - 1][1];
    }

    public int maxProfit_VI(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//第一天买入，收益为负
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], dp[0][1] - prices[1]);//记录两天内买入的最小花费
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1] - fee);//卖出则第一天必须买入，计算所得累计收益。

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }

        //最有一天的持有无法卖出，必定比最后一天的卖出小，所以不必考虑。
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
//        int[] a = new int[]{3, 3, 5, 0, 0, 3, 1, 4}; // 6
        int[] a = new int[]{1, 2, 3, 0, 2}; // 4
//        int[] a = new int[]{7,6,4,3,1}; // 0
//        int[] a = new int[]{1}; //0
//        int[] a = new int[]{1,2,4,2,5,7,2,4,9,0}; //13
//        int[] a = new int[]{2,1,2,1,0,0,1}; //2
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.maxProfit_V(a));
    }
}
