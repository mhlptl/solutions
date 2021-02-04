package solutions;

/**
 * LEETCODE: Maximum Subarray (53) [EASY]
 * 
 * use two variables to keep track of the maxSoFar and actual max
 * the maxSoFar will either be the current value or the (current value + maxSoFar)
 * why? maxSoFar can be negative, therefore nums[i] can be a larger number
 * max will we the max of maxSoFar and max, as we are checking the max on each iteration
 * 
 * TODO: Kadane's Algorithm
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0];
    int max = nums[0];
    
    for(int i = 1; i < nums.length; i++) {
      maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
      max = Math.max(maxSoFar, max);
    }
    
    return max;
  }
}
