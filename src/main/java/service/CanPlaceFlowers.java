package service;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        if (n == 1 && flowerbed.length == 1) {
            return flowerbed[0] == 0;
        }

        //超过可插入数，无法完全插入。
        if (n > flowerbed.length + 1 >> 1) {
            return false;
        }

        //统计连续的3个0，即可插入1。起点终点只需要两个0
        int cnt = 1;//起点只需要两个0，所以默认1。
        for (int j  = 0; j < flowerbed.length; j++) {
            if (flowerbed[j] == 0) {
                if (++cnt == 3) {//是否满足插入
                    if (--n == 0) {//完成了插入，后续不用再查找了
                        return true;
                    }
                    cnt = 1;//插入后，第三个0，可以作为下一批次的起点，所以1。
                }
            } else {//当前位置有有花1，需要重新计数。
                j += 2; //题目有限定，已存在的花，不存在相邻，所以下一个一定是0，跳两格。
                cnt = 1;
            }
        }

        if (cnt == 2) n--;//终点只需要两个0。
        return n == 0;
    }
}
