package solutions;

/**
 * LEETCODE: Find First and Last Position of Element in Sorted Array (34) [MEDIUM]
 * 
 * do binary search to find first and last position
 * when we find the element, mark its index, but dont stop doing binary search
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    int n = nums.length-1;
    int left = binarySearch(nums, 0, n, target, true);
    int right = binarySearch(nums, 0, n, target, false);
    return new int[]{left, right};
  }
  
  private int binarySearch(int[] nums, int lo, int hi, int target, boolean left) {
    int index = -1;
    while(lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if(nums[mid] < target) {
        lo = mid+1;
      }
      else if(nums[mid] > target) {
        hi = mid-1;
      }
      else {
        index = mid;
        if(left) hi = mid-1;
        else lo = mid+1;
      }
    }
    
    return index;
  }
	
}