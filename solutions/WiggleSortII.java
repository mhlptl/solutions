package solutions;

import java.util.Arrays;

/**
 * LEETCODE: Wiggle Sort II (324) [MEDIUM]
 * 
 * create temp arr
 * sort temp arr
 * smallest starts at the middle
 * largest starts at the end
 * keep iterating until normal array is filled
 * decrement smallest and largest
 * increment index pointer everytime we add
 * 
 * TODO: median/virtual indexing
 */
public class WiggleSortII {
	public void wiggleSort(int[] nums) {
    int[] tempArr = Arrays.copyOf(nums, nums.length);
    
    Arrays.sort(tempArr);
    
    int i = 0;
    int n = tempArr.length-1;
    int smallest = n / 2;
    int largest = n;
    
    while(smallest >= 0 && largest >= (n/2)) {
      nums[i++] = tempArr[smallest--];
      if(i <= n) {
        nums[i++] = tempArr[largest--]; 
      }
    }
  }
}
