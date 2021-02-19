package solutions;

/**
 * LEETCODE: Find Peak Element (162) [MEDIUM]
 * 
 * solution 1:
 * linear time
 * find first element which fits the description of being a peak while iterating through array
 * 
 * solution 2:
 * binary search
 * 
 * solution 3:
 * binary search simplifed
 */
public class FindPeakElement {
	public int findPeakElement_solution1(int[] nums) {
    for(int i = 0; i < nums.length-1; i++) {
      if(nums[i] > nums[i+1]) return i;
    }
    
    return nums.length-1;
  }

	public int findPeakElement_solution2(int[] nums) {
    if(nums.length == 0) return -1;
    if(nums.length == 1) return 0;
    return binarySearch_solution2(nums, 0, nums.length-1);
  }
  
  private int binarySearch_solution2(int[] nums, int lo, int hi) {
    if(lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if(mid-1 >= 0 && mid+1 < nums.length && nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
      return mid;
    }
    else if(mid == 0 && mid+1 < nums.length && nums[mid] > nums[mid+1]) {
      return mid;
    }
    else if(mid == nums.length-1 && mid-1 >= 0 && nums[mid-1] < nums[mid]) {
      return mid;
    }
    int left = binarySearch_solution2(nums, lo, mid-1);
    int right = binarySearch_solution2(nums, mid+1, hi);
    return Math.max(left, right);
  }

	public int findPeakElement_solution3(int[] nums) {
    if(nums.length == 0) return -1;
    if(nums.length == 1) return 0;
    return binarySearch_solution3(nums, 0, nums.length-1);
  }
  
  private int binarySearch_solution3(int[] nums, int lo, int hi) {
    if(lo == hi) return lo;
    int mid = lo + (hi - lo) / 2;
    if(mid+1 < nums.length && nums[mid] < nums[mid+1]) {
      return binarySearch_solution3(nums, mid+1, hi);
    }
    return binarySearch_solution3(nums, lo, mid);
  }
}
