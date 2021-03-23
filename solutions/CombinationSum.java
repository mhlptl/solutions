package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE: Combination Sum (39) [MEDIUM]
 * 
 * TODO: writeup
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), 0, candidates, target);
    return result;
  }
  
  private void backtrack(List<List<Integer>> res, List<Integer> curr, int index, int[] nums, int target) {
    if(target < 0) return;
    if(target == 0) {
      res.add(new ArrayList<>(curr));
      return;
    }
    for(int i = index; i < nums.length; i++) {
      curr.add(nums[i]);
      backtrack(res, curr, i, nums, target-nums[i]);
      curr.remove(curr.size()-1);
    }
  }
}