package solutions;

/**
 * LEETCODE: Remove Duplicates from Sorted Array (26) [EASY]
 * 
 * TODO: need writeup
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
    int i = 0;
    int j = 1;
    int n = nums.length;
    
    while(j < n) {
      if(nums[i] != nums[j]) {
        nums[++i] = nums[j];
      }
      j++;
    }
    
    return i+1;
  }
}
