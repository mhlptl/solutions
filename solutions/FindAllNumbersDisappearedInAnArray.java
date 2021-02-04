package solutions;
import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE: Find All Numbers Disappeared in an Array (448) [EASY]
 * 
 * TODO: need writeup
 */
public class FindAllNumbersDisappearedInAnArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    
    for(int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i])-1;
      if(nums[index] > 0) {
        nums[index] *= -1;
      }
    }
		
		List<Integer> result = new ArrayList<>();
		
    for(int i = 1; i <= nums.length; i++) {
      if(nums[i-1] > 0) {
        result.add(i);
      }
    }
    
    return result;
  }
}