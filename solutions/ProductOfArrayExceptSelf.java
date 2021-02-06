package solutions;

/**
 * LEETCODE: Product of Array Except Self (238) [MEDIUM]
 * 
 * TODO: need writeup
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    
    int n = nums.length;
    result[0] = 1;
    
    for(int i = 1; i < nums.length; i++) {
      result[i] = nums[i-1] * result[i-1];
    }
    
    int right = 1;
    
    for(int i = n-1; i >= 0; i--) {
      result[i] = result[i] * right;
      right *= nums[i];
    }
    
    return result;
  }
}