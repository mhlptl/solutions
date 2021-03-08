package solutions;

/**
 * LEETCODE: Search in Rotated Sorted Array (33) [MEDIUM]
 * 
 * alter binary search by adding additional checks
 */
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    return binarySearch(nums, target);
  }
  
  private int binarySearch(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length-1;
    
    while(lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      
      if(nums[mid] == target) return mid;
      else if(nums[mid] >= nums[lo]) {
        if(target >= nums[lo] && target < nums[mid]) {
          hi = mid-1;
        }
        else {
          lo = mid+1;
        }
      }
      else {
        if(target <= nums[hi] && target > nums[mid]) {
          lo = mid+1;
        }
        else {
          hi = mid-1;
        }
      }
    }
    
    return -1;
  }
}
