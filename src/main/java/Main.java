import java.util.*;

/**
 * @author zy
 *
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int personNum = scanner.nextInt();
        int groupCount = scanner.nextInt();
        int[][] group = new int[groupCount][];
        for (int i = 0; i < groupCount; i++) {
            int len = scanner.nextInt();
            group[i] = new int[len];
            for (int j = 0; j < len; j++) {
                group[i][j] = scanner.nextInt();
            }
        }
        Arrays.sort(group,(a,b)->a[0]-b[0]);
        Set<Integer> res = new HashSet<Integer>();


    }




}
