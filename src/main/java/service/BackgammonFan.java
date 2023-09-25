package service;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class BackgammonFan {

    public static int maxSub(int key, int[] arr) {
        int index = -1, len = 0, mid = arr.length >> 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                //记录开始位置left 左边最大查找位，right右边最大查找位；子串左右角标i开始, endIndex结束
                int left, right, endIndex = i;
                int[] tempIndex = {-1, -1};//记录放置位置用作对比

                //从i开始的连续的子串
                while (endIndex < arr.length - 1 && arr[endIndex + 1] == key) {
                    endIndex++;
                }

                int subLength = endIndex - i + 1;
                //查找字串左右是否为0或1，判断当前字串，左右最大长度。可能会重复这是必须的
                //向左先
                left = findEnd(-1, i, tempIndex, 0, key, arr, subLength);
                right = findEnd(1, endIndex, tempIndex, 1, key, arr, subLength);

                //存在-2，表示长度超过5
                if (left == -2 || right == -2) {
                    return -1;
                }

                //都为-1，没有合适位置放置
                if (left == right && left == -1) {
                    continue;
                }

                //计算左右各自字串最大长度
                int subLeft = left != -1 ? endIndex - left + 1 : -1;
                int subRight = right != -1 ? right - i + 1 : -1;

                //记录放置位
                int index_t = -1;
                if (subLeft == subRight && subLeft != -1) {
                    index_t = closer(mid, tempIndex[0], tempIndex[1]);
                } else if (subLeft > subRight) {
                    index_t = tempIndex[0];
                } else if (subLeft < subRight) {
                    index_t = tempIndex[1];
                    subLeft = subRight;
                }

                //判断是否大于已存长度，是则替换
                if (subLeft > len) {
                    len = subLeft;
                    index = index_t;
                } else if (subLeft == len) {//长度一致，需要判断是否点更接近中间
                    index = closer(mid, index_t, index);
                }

                i = endIndex;
            }
        }


        return index;
    }

    static int findEnd(int add, int index, int[] tempIndex, int tempLocate, int key, int[] arr, int subLen) {
        boolean hold = true;
        while (true) {
            if (subLen >= 5) {
                return -2;
            }

            index = index + add;
            //左右方向判断条件不一样
            boolean judge = (add == -1 && index < 0) || (add == 1 && index > arr.length - 1);

            //越界，0已使用或不等于key时
            if (judge || (arr[index] == 0 && !hold) || arr[index] == key * -1) {
                index = index - add;
                return hold ? -1 : index;//占位未使用，表示向左没有合适位置，节点无用置为-1
            }

            //字串长度+1
            subLen++;

            //存在
            if (arr[index] == 0 && hold) {
                hold = false;
                tempIndex[tempLocate] = index;//放置位置
            }
        }
    }

    //返回最接近中间点的角标
    public static int closer(int mid, int f, int s) {
        int f_diff = Math.abs(mid - f);
        int s_diff = Math.abs(mid - s);

        return f_diff <= s_diff ? f : s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] strings = in.nextLine().split(" ");
        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        int r = maxSub(n, array);
        System.out.println(r);
//        String[] a = {"bb", "a", "c"};
//        Arrays.sort(a);
//        Arrays.copyOf();
//        System.out.println(Arrays.toString(a));

    }
}
