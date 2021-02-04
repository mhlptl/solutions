package solutions;
import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE: Two Sum (1) [EASY]
 * 
 * use hashmap to keep track of the elements we've seen and its index
 * if the (target - current value) is in the hashmap,
 * return the index linked to it in the hashmap and the current index
 * why does this work? if x + y = target, we can store x for easy lookup,
 * and then try to check if (target - y) aka x is in our lookup table (hashmap)
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for(int i = 0; i < nums.length; i++) {
      int rem = target - nums[i];
      if(map.containsKey(rem)) {
        return new int[]{map.get(rem), i};
      }
      map.put(nums[i], i);
    }
    
    return new int[]{};
  }
}
