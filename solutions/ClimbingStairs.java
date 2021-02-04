package solutions;
import java.util.Arrays;

/**
 * LEETCODE: Climbing Stairs (70) [EASY] 
 * 
 * memoization solution
 * use array to keep track of values we have already seen
 * why? so we dont have to repeat work we've already done
 * the value stored at memo[n] is where the result is stored
 * 
 * dynamic programming solution
 * we can do this in O(1) space
 * in an array keep iterating and replacing the values in variables
 * reminder: this has the same sequence as the fibonacci sequence
 * at the end of the array, the value in the second variable is our answer
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
    int[] memo = new int[n+1];
    Arrays.fill(memo, -1);
    int memoization_result = climbStairs_memo(n, memo);
		int dp_result = climbStairs_dp(n);
		return dp_result;
  }
  
  private int climbStairs_memo(int n, int[] memo) {
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    if(memo[n] != -1) return memo[n];
    memo[n] = climbStairs_memo(n-1, memo) + climbStairs_memo(n-2, memo);
    return memo[n];
  }
  
  private int climbStairs_dp(int n) {
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int first = 1;
    int second = 2;
    
    for(int i = 3; i <= n; i++) {
      int newVal = first+second;
      first = second;
      second = newVal;
      
    }
    return second;
  }
}
