
// @Title: 零钱兑换 II (Coin Change 2)
// @Author: luffyyy@vip.qq.com
// @Date: 2021-11-08 22:57:28
// @Runtime: 7 ms
// @Memory: 45 MB

class Solution {
    public int change(int amount, int[] coins) {
        int[][] map = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    map[i][j] = 1;
                    continue;
                }
                if (i == 0){
                    if(j % coins[0] == 0) {
                        map[0][j] = 1;
                    }
                    continue;
                }
                if (j >= coins[i] && i - 1 >= 0) {
                    map[i][j] = map[i - 1][j] + map[i][j - coins[i]];
                } else {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        return map[coins.length - 1][amount];
    }
}
