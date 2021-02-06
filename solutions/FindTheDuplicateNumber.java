package solutions;
import java.util.HashSet;

/**
 * LEETCODE: Find the Duplicate Number (287) [MEDIUM]
 * 
 * solution 1: O(N) space
 * use hashset to find duplicate number
 * but does not change the array elements
 * 
 * solution 2: O(1) space
 * uses the array itself to keep track of duplicate
 * but changes the array elements
 * 
 * TODO: solution 3: fast/slow pointer
 * uses O(1) space and does not change array elements
 */
public class FindTheDuplicateNumber {
	
	// solution 1
	public int findDuplicate_solution1(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    
    for(int num: nums) {
      if(set.contains(num)) return num;
      set.add(num);
    }

    return -1;
  }

	// solution 2
	public int findDuplicate_solution2(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]);
      if(nums[index] < 0) return index;
      if(nums[index] > 0) nums[index] *= -1;
    }
    
    return -1;
  }
}
