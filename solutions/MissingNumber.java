package solutions;

/**
 * LEETCODE: Missing Number (268) [EASY]
 * 
 * use bit manipulation XOR
 * set result to the length of the array 
 * (because the values in the array will be between 0...n)
 * on each interation set result to the XOR of result, i, and nums[i]
 * at the end of the loop, result will be equal to the missing number
 * why? if we keep XORing the same numbers, it will equal 0
 * and the missing number will reveal itself because
 * all the values of nums, and 0...n will be matching except for one value
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
    int result = nums.length;
    
    for(int i = 0; i < nums.length; i++) {
      result = (result ^ i) ^ nums[i];
    }
    
    return result;
  }
}
