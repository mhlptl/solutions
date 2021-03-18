package solutions;

/**
 * LEETCODE: Longest Increasing Subsequence (300) [MEDIUM]
 * 
 * break problem into smaller subproblems
 * 
 * TODO: need better writeup
 * TODO: nlogn solution
 */
public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    if(nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    
    dp[0] = 1;
    
    int result = 1;
    
    for(int i = 1; i < nums.length; i++) {
      int maxVal = 0;
      for(int j = 0; j < i; j++) {
        if(nums[j] < nums[i]) {
          maxVal = Math.max(maxVal, dp[j]);
        }
      }
      dp[i] = maxVal + 1;
      result = Math.max(result, dp[i]);
    }
    
    return result;
  }
	
}