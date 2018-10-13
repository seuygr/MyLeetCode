package solution;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        // dp[i][j] represents the number of combintaions to amount j using the first i coins
        int[][] dp = new int[coins.length + 1][amount  + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
    public static void main(String[] args) {
    	int amount = 5;
    	int[] coins = new int[] {1, 2, 5};
    	CoinChange2 sol = new CoinChange2();
    	System.out.print(sol.change(amount, coins));
    }
}
