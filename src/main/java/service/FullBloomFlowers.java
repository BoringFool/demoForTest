package service;

import java.util.Arrays;

public class FullBloomFlowers {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int length = flowers.length;
        int[] starts = new int[length];
        int[] ends = new int[length];
        int i = 0;

        for (int[] arr : flowers) {
            starts[i] = arr[0];
            ends[i] = arr[1];
            i++;
        }
        //排序后，每增加一个开始时间节点，则表示观赏花+1，刚好符合数组的角标递增。所以数组角标，表示当前的总花数。
        Arrays.sort(starts);
        //原理同上，表示需要减去的花数
        Arrays.sort(ends);

        for (int j = 0; j < people.length; j++) {
            people[j] = search_start(starts, people[j]) - search_start(ends, people[j] - 1);
        }

        return people;
    }

    private int search_start(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + ((right - left ) >> 1);
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 6},{9, 12},{4, 13}, {3, 7}};
        int[] b = new int[]{2,3,7,11};
        FullBloomFlowers fullBloomFlowers = new FullBloomFlowers();
        System.out.println(fullBloomFlowers.fullBloomFlowers(a, b));
    }
}
