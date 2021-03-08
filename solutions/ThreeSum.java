package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LEETCODE: 3Sum (15) [MEDIUM]
 * 
 * we can use Two Sum II to solve this problem
 * when we find a triplet increment j (lower) until theres no duplicate
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    
    for(int i = 0; i < nums.length; i++) {
      if(i-1 >= 0 && nums[i-1] == nums[i]) continue;
      int num1 = nums[i];
      int j = i+1;
      int k = nums.length-1;
      while(j < k) {
        int num2 = nums[j];
        int num3 = nums[k];
        int sum = num1 + num2 + num3;
        if(sum == 0) {
          List<Integer> list = new ArrayList<>();
          list.add(num1);
          list.add(num2);
          list.add(num3);
          result.add(list);
          while(j < k && num2 == nums[j]) {
            j++;
          }
        }
        else if(sum < 0) {
          j++;
        }
        else if(sum > 0) {
          k--;
        }
      }
    }
    
    return result;
  }
}
