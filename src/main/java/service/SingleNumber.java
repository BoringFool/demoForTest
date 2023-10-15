package service;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public int singleNumber_I(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {//取出每一位
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> i) & 1;//统计当前位，所有的和
            }

            //0就不需要复位，1需要复位。加不加这个判断执行时间差不多。
            if (cnt % 3 != 0) {
                ans |= (1 << i);
            }

//            ans |= (cnt % 3) << i;
        }

        return ans;
    }
}
