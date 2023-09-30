package service;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EarliestFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Pair<Integer, Integer>> q = new ArrayList<>();

        int max = 0, planted = 0;
        for (int i = 0; i < plantTime.length; i++) {
            q.add(new Pair<>(plantTime[i], growTime[i]));
        }

        q.sort((o1, o2) -> !o2.getValue().equals(o1.getValue()) ? o2.getValue() - o1.getValue() : o2.getKey() - o1.getKey());

        for (Pair<Integer, Integer> v : q) {
            planted += v.getKey();
            max = Math.max(max, planted + v.getValue());
        }

        return max - 1;
    }
    public int earliestFullBloom_(int[] plantTime, int[] growTime) {
        //创建对象浪费时间，优化一下只排序角标
        int n = plantTime.length;
        Integer[] id = new Integer[n];//下面排序需要对象转int，直接int数组报错
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (i, j) -> growTime[j] - growTime[i]);
        int max = 0, planted = 0;
        for (int i : id) {
            planted += plantTime[i];
            max = Math.max(max, planted + growTime[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 3};
        int[] b = new int[]{2, 3, 1};
        EarliestFullBloom fullBloom = new EarliestFullBloom();
        System.out.println(fullBloom.earliestFullBloom(a, b));
    }
}
