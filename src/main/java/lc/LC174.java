package lc;

import java.util.Arrays;

public class LC174 {


    public static void main(String[] args) {
        int[][] input = new int[1][2];
        input[0][0] = 0;
        input[0][1] = -3;
        int i = calculateMinimumHP(input);
        System.out.println(i);

    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // 从右下到左上, dp[i][j] 代表 点i,j 到终点所需要最小的体力.
        int[][] dp = new int[m + 1][n + 1];
        // 初始化为最大值
        for (int i = 0; i <= dungeon.length; i ++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : (1 - dungeon[m - 1][n - 1]);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == (m - 1) && j == (n - 1)) {
                    continue;
                } else {
                    // 选择接下来要走的最佳路(下一步所需体力最少的)
                    int minPath = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(minPath - dungeon[i][j], 1);
                }
            }
        }
        return dp[0][0];

    }
}
