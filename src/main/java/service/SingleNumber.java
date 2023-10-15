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

    public int[] singleNumber_II(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total ^= num;
        }

        int diff = 0;
        //找到和的最低位的1
        for (int i = 0; i < 32; i++) {
            if (((total >> i) & 1) == 1) {
                diff = i;
                break;
            }
        }

        int num1 = 0;
        //计算出最低位为1的数
        for (int num : nums) {
            if (((num >> diff) & 1) == 1) {
                num1 ^= num;
            }
        }

        //num1再异或一次，total就等于num2了
        return new int[]{num1, total ^ num1};
    }
}
