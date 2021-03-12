package solutions;

import java.util.Arrays;

/**
 * LEETCODE:Coin Change (322) [MEDIUM]
 * 
 * solution 1: 2D DP
 * keep track of solutions for each amount @ each coin value
 * 
 * solution 2: 1D DP
 * keep track of solutions for each amount @ each coin value in 1D array
 * 
 * for both:
 * replace value at current index if we find a combination of coins that is less than the number of coins already found
 * 
 */
public class CoinChange {

	public int coinChange_solution1(int[] coins, int amount) {
    int[][] dp = new int[coins.length+1][amount+1];
    
    for(int i = 0; i <= coins.length; i++) {
      Arrays.fill(dp[i], amount+1);
    }
    
    for(int i = 0; i <= coins.length; i++) {
      dp[i][0] = 0;
    }
    
    // Arrays.sort(coins);
    
    for(int i = 1; i <= coins.length; i++) {
      for(int j = 1; j <= amount; j++) {
        if(coins[i-1] <= j) {
          dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
        }
        else {
          dp[i][j] = dp[i-1][j];
        }
      }
		}
    
    return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
  }

  public int coinChange_solution2(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    
    Arrays.fill(dp, amount+1);
    
    dp[0] = 0;
    
    for(int currAmount = 1; currAmount <= amount; currAmount++) {
      for(int coin: coins) {
        if(coin > currAmount) break;
        dp[currAmount] = Math.min(dp[currAmount - coin] + 1, dp[currAmount]);
      }
    }
    
    return dp[amount] > amount ? -1 : dp[amount];
  }
	
}