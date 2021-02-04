package solutions;
import java.util.List;
import java.util.ArrayList;

/**
 * LEETCODE: Subsets (78) [MEDIUM]
 * 
 * add to result list
 * start index i at given index
 * add to list
 * call backtracking algo, but with index i + 1
 * remove from list
 * this uses backtracking to create the subsets
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    subsetGeneration(nums, result, new ArrayList<Integer>(), 0);
    return result;
  }
  
  private void subsetGeneration(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
    res.add(new ArrayList<Integer>(list));
    for(int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      subsetGeneration(nums, res, list, i+1);
      list.remove(list.size()-1);
    }
  }
}
