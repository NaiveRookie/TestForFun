package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC131 {

    public static void main(String[] args) {
//        Arrays.fill();
        LC131 lc131 = new LC131();


    }

    List<List<String>> res;
    List<String> temp = new ArrayList<>();
    boolean[][] dp;
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }

        // 初始化字符串ij 之间是否是索引
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return res;
    }

    /**
     * @param s
     * @param index 递归的索引位置
     */
    public void dfs(String s, int index) {
        if (index == n) {
            res.add(temp);
            return;
        }
        for (int i = index; i < n; i++) {
            // 如果当前的范围是回文, 记录并进入下一轮递归
            if (dp[index][i]) {
                temp.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
