package solutions;

/**
 * LEETCODE: Merge Sorted Array (88) [EASY]
 * 
 * start at end of array to fill
 * start iterating from the end of both arrays to the front
 * the larger element gets put in the array
 * keep doing this until one of the pointers for the two arrays become less than zero
 * if one of the pointers is not less than 0, keep adding the elements to the array
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
    int k = nums1.length-1;
    m--;
    n--;
    
    while(n >= 0 && m >= 0) {
      if(nums1[m] > nums2[n]) {
        nums1[k--] = nums1[m--];
      }
      else {
        nums1[k--] = nums2[n--];
      }
    }
    
    while(n >= 0) {
      nums1[k--] = nums2[n--];
    }
    
    while(m >= 0) {
      nums1[k--] = nums1[m--];
    }
  }
}
