package service;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumDistance {
    public int sumDistance(int[] nums, String s, int d) {
        final long MOD = (long) 1000000007;
        int n = nums.length;
        long[] a = new long[n]; // 用 long 是因为 nums[i]+d 可能是 2e9+1e9，溢出了
        for (int i = 0; i < n; i++) {
            a[i] = (long) nums[i] + (s.charAt(i) == 'L' ? -d : d);
        }
        Arrays.sort(a);

        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + i * a[i] - sum) % MOD;
            sum += a[i];
        }
        return (int) ans;
    }
}
