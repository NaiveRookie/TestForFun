/**
 * @author coolestyue
 * 要努力呀.
 */
public class TestChar {
    public static void main(String[] args) {
        char a = '0';
        System.out.println("char '0' 的大小为"+(int)a);
        int b = 'a';
        System.out.println("char 'a' 的大小为"+(int)b);
        System.out.println("'a'-'0'的大小为:"+(int)('a'-'0'));
        char c = '1' + 1;
        System.out.println(c);
    }
    boolean[][] rowMap = new boolean[9][9];
    boolean[][] colMap = new boolean[9][9];
    // i / 3, j / 3
    boolean[][][] boxMap = new boolean[3][3][9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++)
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1'; // char = 1 则索引为0(第一个位置)
                    rowMap[i][index] = colMap[j][index] = boxMap[i / 3][j / 3][index] = true;
                }
            }
        dfs(board, 0, 0);
    }
    public boolean dfs(char[][] board, int x, int y) {
        if (y == 9) x ++ ; y = 0;
        if (x == 9) return true;
        if (board[x][y] != '.') return dfs(board, x, y + 1);
        else {
            for (int i = 0; i < 9; i ++) {
                if (!rowMap[x][i] && !colMap[y][i] && !boxMap[x / 3][y / 3][i]){
                    board[x][y] = (char) ('1' + i);
                    // rowMap[x][num] = colMap[y][num] = boxMap[x / 3][y / 3][num] = true;
                    if (dfs(board, x, y + 1)) return true;
                    // rowMap[x][num] = colMap[y][num] = boxMap[x / 3][y / 3][num] = false;
                    board[x][y] = '.';
                }
            }
            return false;
        }
    }
}
