package service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxKElements {
    public long maxKElements(int[] nums, int k) {
        //降序排序
        nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::valueOf).toArray();
        int ans = 0;

        while (k > 0) {
            k--;
            ans += nums[0];
            nums[0] = (int) Math.ceil((double) nums[0] / 3);

            int i = 0, j = i + 1;
            while (j < nums.length && nums[i] < nums[j]) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;

                i = j;
                j = i + 1;
            }
        }

        return ans;
    }

    public long maxKElements_I(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i : nums) {
            q.add(i);
        }

        long ans = 0;

        while (k > 0 && !q.isEmpty()) {
            k--;
            int val = q.poll();
            ans += val;
            val = (int) Math.ceil((double) val / 3);
            q.add(val);
        }

        return ans;
    }
}
