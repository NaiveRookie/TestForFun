import java.util.Scanner;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        int midright= len/2;
        int midLeft = midright-1;
        for (int i = 0; i < len; i++) {
            if(i<=midLeft){
                System.out.println(nums[midright]);
            }else{
                System.out.println(nums[midLeft]);
            }
        }

    }
    public static int sickChicken(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= num; i++) {
            dp[i] = 2 * dp[i - 3];
        }
        return dp[num];
    }
}
