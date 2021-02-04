package solutions;
import java.util.Arrays;

/**
 * LEETCODE: Majority Element (169) [EASY]
 * 
 * sort array and return middle element
 * 
 * TODO: Boyer-Moore Voting Algorithm
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
    Arrays.sort(nums);

    return nums[(nums.length-1) / 2];
  }
}
