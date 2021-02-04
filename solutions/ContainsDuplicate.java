package solutions;
import java.util.Set;
import java.util.HashSet;

/**
 * LEETCODE: COntains Duplicate (217) [EASY]
 * 
 * to check if array contains duplicate use hashset
 * if the value exists in the set, there is a duplicate
 * after checking if the value exists in the set, add it to the set
 * adding to the set will only work if the value does not exist in the set
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();

    for(int num: nums) {
      if(set.contains(num)) return true;
      set.add(num);
    }
    return false;
  }
}
