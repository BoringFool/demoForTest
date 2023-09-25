package service;

import java.util.Scanner;

public class Dfs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();

        int[][] v = new int[num][3];
        for (int i = 0; i < num; i++) {
            v[i][0] =in.nextInt();
            v[i][1] =in.nextInt();
            v[i][2] =in.nextInt();
            in.nextLine();
        }

        System.out.println(dfs(v, -1, 0, num));
    }

    static int dfs(int[][] option, int exclude, int level, int num) {
        if (num == 0) {
            return 0;
        }

        int[] op = option[level];
        int min = 0;

        for (int i = 0; i < op.length; i++) {
            if (i != exclude) {
                if (min == 0) {//第一个记录
                    min = op[i] + dfs(option, i, level + 1, num - 1);
                } else {
                    min = Math.min(min, op[i] + dfs(option, i, level + 1, num - 1));
                }
            }
        }

        return min;
    }
}
