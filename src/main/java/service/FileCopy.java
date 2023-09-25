package service;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class FileCopy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();

        int[] all = new int[size];

        for (int i = 0; i < size; i++) {
            all[i] = in.nextInt();
            in.nextLine();
        }

        int limit = 1474560 / 512;
        int[][] dp = new int[size][limit + 1];

        int key = (all[0] % 512 != 0 ? 1 : 0) + all[0] / 512;
        for (int i = key; i <= limit; i++) {
            dp[0][i] = all[0];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= limit; j++) {
                //计算实际占用大小
                key = (all[i] % 512 != 0 ? 1 : 0) + all[i] / 512;

                if (j - key >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - key] + all[i]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[size - 1][limit]);
    }
}
