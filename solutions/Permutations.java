package solutions;
import java.util.List;
import java.util.ArrayList;

/**
 * LEETCODE: Permutations (46) [MEDIUM]
 * 
 * to make permutations, the size of the list needs to equal the size of the array
 * if the list contains the current value continue
 * if it doesnt, add it to the list, call permute and then remove it from the list
 * this uses backtracking to build the permutation list
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute(nums, result, new ArrayList<Integer>());
    return result;
  }
  
  private void permute(int[] nums, List<List<Integer>> res, List<Integer> list) {
    if(list.size() == nums.length) {
      res.add(new ArrayList<Integer>(list));
      return;
    }
    
    for(int i = 0; i < nums.length; i++) {
      if(list.contains(nums[i])) continue;
      list.add(nums[i]);
      permute(nums, res, list);
      list.remove(list.size()-1);
    }
  }
}
