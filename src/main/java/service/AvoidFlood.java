package service;

import java.util.*;

public class AvoidFlood {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 0, 0, 2, 1};
        AvoidFlood avoidFlood = new AvoidFlood();
        System.out.println(avoidFlood.avoidFlood(a));
    }

    public int[] avoidFlood(int[] rains) {
        int[] cnt = new int[rains.length];
        Map<Integer, Integer> filled = new HashMap<>();
        List<Integer> days = new LinkedList<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                //记录第i天可以排水
                days.add(i);
            } else {
                cnt[i] = -1;//当天下雨

                //当前湖泊已经满了，需要抽空
                if (filled.containsKey(rains[i])) {
                    //当前湖泊被填满的日期
                    int day = filled.get(rains[i]);

                    //查找day和i之间可排水的日期
                    Iterator<Integer> it = days.listIterator();
                    while (it.hasNext()) {
                        int zero = it.next();
                        if (zero > day) {
                            cnt[zero] = rains[i];
                            it.remove();
                            day = -1;
                            break;
                        }
                    }

                    if (day != -1) return new int[]{};
                }


                //湖泊在第i天填满
                filled.put(rains[i], i);
            }
        }

        //剩余的0，默认抽一号湖泊
        for (int day : days) {
            cnt[day] = 1;
        }

        return cnt;
    }
}
