package solutions;

/**
 * LEETCODE: Rotate Array (189) [MEDIUM]
 * 
 * reverse array from 0..n
 * reverse from 0..k
 * reverse from k..n
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if(k == 0) return;
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums.length-1);
    
  }
  
  private void reverse(int[] nums, int start, int end) {
    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
