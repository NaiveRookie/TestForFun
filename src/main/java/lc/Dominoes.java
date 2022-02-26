package lc;

public class Dominoes {

    public static String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int i = 0, len = dominoes.length();
        char l = 'L';
        int j;
        while (i < len) {
            j = i;
            while (j < len && s[j] == '.') {
                j++;
            }
            char r = j < len ? s[j] : 'R';
            // 方向一致, 全部一边倒
                                                                                                                                                                                                                                if (l == r) {
                while (l < r) {
                    s[l++] = r;
                }
            } else if (l == 'R' && r == 'L') {
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            l = r;
            i = j + 1;
        }
        return new String(s);
    }

    public static void main(String[] args) {
        String str = "R..L";
        String s = pushDominoes(str);

    }
}
