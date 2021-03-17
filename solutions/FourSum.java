package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LEETCODE: 4Sum (18) [MEDIUM]
 * 
 * all kSum questions at their simplest form is a TwoSum Problem
 * use recursion to mimic k loops until k == 2 where we can use TwoSum
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, 0, 4, target);
  }
  
  private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if(start == nums.length) return result;
    if(k == 2) {
      return twoSum(nums, target, start);
    }
    for(int i = start; i < nums.length; i++) {
      if(i > start && nums[i-1] == nums[i]) continue;
      List<List<Integer>> lists = kSum(nums, i+1, k-1, target-nums[i]);
      for(List<Integer> tempList: lists) {
        result.add(new ArrayList<>(Arrays.asList(nums[i])));
        result.get(result.size()-1).addAll(tempList);
      }
    }
    return result;
  }
  
  // all k-sum problems result into a 2sum problem at the most simplest form
  private List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> list = new ArrayList<>();
    int i = start;
    int j = nums.length-1;
    
    while(i < j) {
      int sum = nums[i] + nums[j];
      if(sum == target) {
        list.add(Arrays.asList(nums[i++], nums[j--]));
        while(i < j && nums[i-1] == nums[i]) {
          i++;
        }
      }
      else if(sum < target) {
        i++;
      }
      else {
        j--;
      }
    }
    
    return list;
  }
}
