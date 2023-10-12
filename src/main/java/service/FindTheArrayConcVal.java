package service;

public class FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0, right = nums.length - 1;
        long ans = 0;

        while(left < right){
            //两个Integer.toString效率比+""或者单独一个Integer.toString效率高。
            ans += Integer.parseInt(Integer.toString(nums[left++]) + Integer.toString(nums[right--]));
        }

        if (left == right) ans += nums[left];
        return ans;
    }
}
