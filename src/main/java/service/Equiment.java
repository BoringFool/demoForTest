package service;

import java.util.*;

public class Equiment {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int equ = in.nextInt();
        in.nextLine();

        int size = in.nextInt();
        in.nextLine();
        Map<Integer, List<Eq>> map = new HashMap<>();

        while (--size >= 0) {
            Eq eqs = new Eq();
            int type = in.nextInt();
            eqs.reliability = in.nextInt();
            eqs.price = in.nextInt();
            in.nextLine();

            List<Eq> list = map.computeIfAbsent(type, k -> new ArrayList<>());
            list.add(eqs);
        }

        int[][] dp = new int[equ][total + 1];

        //从高到底稳定性
        List<Eq> list = map.get(0);
        list.sort(Comparator.comparingInt(o -> o.price));
        for (int i = 0; i <= total; i++) {
            dp[0][i] = 0;
            for (Eq eq : list) {
                if (eq.price <= i) {
                    dp[0][i] = Math.max(dp[0][i], eq.reliability);
                }
            }
        }

        for (int i = 1; i < equ; i++) {
            //从高到底稳定性
            list = map.get(i);
            for (int j = 0; j <= total; j++) {
                for (Eq eq : list) {
                    if (j - eq.price >= 0) {
                        dp[i][j] = Math.max(dp[i][j], Math.min(dp[i - 1][j - eq.price], eq.reliability));
                    }

                }
            }
        }

        System.out.println(dp[equ - 1][total]);


    }

    static class Eq {
        int price;
        int reliability;
    }

}
