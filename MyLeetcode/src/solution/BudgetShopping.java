package solution;
import java.util.*;

public class BudgetShopping {
    public int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
    // Write your code here
        // using dynamic programming
        // dp[i][j] represents the maximum number of book Helen can get buying the first i bundles with j dollars.
        int[][] dp = new int[bundleQuantities.size() + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j >= bundleCosts.get(i - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], bundleQuantities.get(i - 1) + dp[i][j - bundleCosts.get(i - 1)]); 
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[bundleQuantities.size()][n];
    }
    
    public static void main(String[] args) {

    	System.out.print((char) 49);
    	
    	
    }
}
