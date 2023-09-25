package service;

public class LifePlant {
    static final String YES = "YES";
    static final String NO = "NO";
    static final String NA = "NA";


    public static void main(String[] args) {
//        String[][] t = {{"YES", "NO", "NO", "YES"}, {"NO", "NO", "YES", "NO"}, {"NO", "YES", "NA", "NA"}, {"YES", "NO", "NA", "NO"}}; //-1
//        String[][] t = {{"YES", "NO", "NO", "NO"}, {"NO", "NO", "NO", "NO"}, {"NO", "NO", "NO", "NO"}, {"NO", "NO", "NO", "NO"}};//6
        String[][] t = {{"YES", "YES", "NO"}, {"NO", "NO", "NO"}, {"YES", "NO", "NO"}};//2
        System.out.println(compute(t));
    }

    static int compute(String[][] area) {
        int row = area.length;
        int col = area[0].length;
        int[][] mark = new int[row][col];
        int day = 1;//改造天数，如果可改造的话

        //第一次标记，查看是否有死区，同时统计需要改造的区域
        int totalCount = 0;
        boolean ifHaveYes = false;//是否有可用YES

        //第一轮标记
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (NO.equals(area[i][j])) {
                    totalCount += 1;

                    //判断是否可改造
                    int[] around = getAround(area, i, j);
                    if (around[0] == around[1] && around[1] == around[2] && around[2] == around[3] && around[1] == -1) {
                        return -1;
                    }

                    //判断是否会在当天被改造
                    if (around[0] == 1 || around[1] == 1 || around[2] == 1 || around[3] == 1) {
                        mark[i][j] = 1;
                    }
                } else if (YES.equals(area[i][j])) {
                    //判断是否可改造
                    int[] around = getAround(area, i, j);
                    if ((around[0] != -1 || around[1] != -1 || around[2] != -1 || around[3] != -1) && !ifHaveYes) {
                        ifHaveYes = true;
                    }
                }
            }
        }

        totalCount = deal(area, mark, totalCount);


        //改造
        while (totalCount != 0) {
            day++;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < area[i].length; j++) {
                    if (NO.equals(area[i][j])) {
                        //判断是否可改造
                        int[] around = getAround(area, i, j);

                        //判断是否会在当天被改造
                        if (around[0] == 1 || around[1] == 1 || around[2] == 1 || around[3] == 1) {
                            mark[i][j] = 1;
                        }
                    }
                }
            }

            totalCount = deal(area, mark, totalCount);
        }


        return day;
    }

    //改造
    static int deal(String[][] source, int[][] mark, int totalNo) {
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[i].length; j++) {
                if (mark[i][j] == 1) {
                    source[i][j] = "YES";
                    mark[i][j] = 0;
                    totalNo--;
                }
            }
        }

        return totalNo;
    }

    static int[] getAround(String[][] area, int i, int j) {
        int[] data = {-1, -1, -1, -1};

        if (j - 1 >= 0) {
            String value = area[i][j - 1];
            data[0] = YES.equals(value) ? 1 : NO.equals(value) ? 0 : -1;
        }

        if (i - 1 >= 0) {
            String value = area[i - 1][j];
            data[1] = YES.equals(value) ? 1 : NO.equals(value) ? 0 : -1;
        }

        if (j + 1 < area[0].length) {
            String value = area[i][j + 1];
            data[3] = YES.equals(value) ? 1 : NO.equals(value) ? 0 : -1;
        }

        if (i + 1 < area.length) {
            String value = area[i + 1][j];
            data[2] = YES.equals(value) ? 1 : NO.equals(value) ? 0 : -1;
        }
        return data;
    }
}
