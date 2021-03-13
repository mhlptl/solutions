package solutions;

/**
 * LEETCODE: Maximum Product Subarray (152) [MEDIUM]
 * 
 * use temp variable to store the maxSoFar so we can still do calculations for minSoFar
 * maxSoFar will be the max of the currentNumber, maxSoFar * currentNumber, minSoFar * currentNumber
 * minSoFar will be the min of the currentNumber, maxSoFar * currentNumber, minSoFar * currentNumber
 * the result will be the max of itself and maxSoFar
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
    
    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int result = nums[0];
    
    for(int i = 1; i < nums.length; i++) {
      int tempMax = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
      minSoFar = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));
      maxSoFar = tempMax;
      
      result = Math.max(maxSoFar, result);
    }
    
    return result;
  }
}
