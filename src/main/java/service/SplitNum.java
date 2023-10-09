package service;

import java.util.Arrays;

public class SplitNum {
    public int splitNum(int num) {
        String s = Integer.toString(num);
        String[] nums = s.split("");
        int[] i = new int[nums.length % 2 == 0 ? nums.length : nums.length + 1];

        for (int j = 0; j < nums.length; j++) {
            i[j] = Integer.parseInt(nums[j]);
        }

        Arrays.sort(i);

        int num1 = 0, num2 = 0;


        for (int j = 0; j < i.length; j++) {
            num1 = num1 * 10 + i[j];
            num2 = num2 * 10 + i[++j];
        }

        return num1 + num2;
    }

    public int splitNum_I(int num) {
        char[] stnum = Integer.toString(num).toCharArray();
        Arrays.sort(stnum);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < stnum.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (stnum[i] - '0');//char的数字int值，实际是减去char0得到的差值。
            } else {
                num2 = num2 * 10 + (stnum[i] - '0');
            }
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
        SplitNum splitNum = new SplitNum();

        System.out.println(splitNum.splitNum(430));
    }
}
