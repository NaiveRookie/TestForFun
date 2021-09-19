/**
 * @author coolestyue
 * 要努力呀.
 */
public class TestChouShu {
    public static void main(String[] args) {
        nthUglyNumber(3,2,3,5);
    }
    public static int nthUglyNumber(int n, int a, int b, int c) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        for(int i = 1;i<=n;i++){
            int min = Math.min(dp[aIndex]*a,Math.min(dp[bIndex]*b,dp[cIndex])*c);
            dp[i] = min;
            if(min==dp[aIndex]*a) aIndex++;
            if(min==dp[bIndex]*b) bIndex++;
            if(min==dp[cIndex]*c) cIndex++;
        }
        return dp[n];
    }
}
