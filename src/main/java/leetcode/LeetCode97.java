package leetcode;

/**
 * @author zy
 * @Date 12:29 2021/10/7
 * @Description
 */
public class LeetCode97 {

    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a.substring(3));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) return false;

        boolean[][] arr = new boolean[l1 + 1][l2 + 1];
        arr[0][0] = true;

        for (int i = 0; i <= l1; i ++) {
            for (int j = 0; j <= l2; j ++) {
                int p = i + j - 1;
                if (i > 0) {
                    arr[i][j] = (arr[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(p)));
                }
                if (j > 0) {
                    arr[i][j] = arr[i][j] || arr[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return arr[l1][l2];

    }
}
