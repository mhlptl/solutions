package solutions;

import java.util.Arrays;

/**
 * LEETCODE: House Robber (198) [MEDIUM]
 * 
 * solution1:
 * - recursive
 * 
 * solution2:
 * - recursive, using memoization to save answers to reduce duplicate work
 * 
 * solution3:
 * - iterative, extra space
 * 
 * solution4:
 * - iterative, O(1) space
 */
public class HouseRobber {

	public int solution1(int[] nums) {
    return rob_solution1(nums, nums.length-1);
  }
  
  private int rob_solution1(int[] nums, int n) {
    if(n < 0) return 0;
    return Math.max(rob_solution1(nums, n-1), rob_solution1(nums, n-2) + nums[n]);
  }


	public int solution2(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return rob_solution2(nums, nums.length-1, memo);
  }
  
  private int rob_solution2(int[] nums, int n, int[] memo) {
    if(n < 0) return 0;
    if(memo[n] != -1) return memo[n];
    memo[n] = Math.max(rob_solution2(nums, n-1, memo), rob_solution2(nums, n-2, memo) + nums[n]);
    return memo[n];
  }

	public int solution3(int[] nums) {
    if(nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];
    if(nums.length == 2) return Math.max(nums[0], nums[1]);
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for(int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
    }
    
    return dp[nums.length-1];
  }

	public int solution4(int[] nums) {
    int num1 = 0;
    int num2 = 0;
    
    for(int i = 0; i < nums.length; i++) {
      int temp = num2;
      num2 = Math.max(num2, nums[i] + num1);
      num1 = temp;
    }
    
    return num2;
  }
}
