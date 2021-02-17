package solutions;

/**
 * LEETCODE: Sort Colors (75) [MEDIUM]
 * 
 * solution 1:
 * two pass solution
 * get number of zeros and ones (can infer number of twos)
 * overwrite values in sorted order (zeros, ones, twos)
 * 
 * solution 2:
 * one pass solution
 * two pivot points
 * TODO: need writeup
 */
public class SortColors {
	public void sortColors_solution1(int[] nums) {
    int numZeros = 0;
    int numOnes = 0;
    
    for(int num: nums) {
      if(num == 0) numZeros++;
      else if(num == 1) numOnes++;
    }
    
    int i = 0;
    for(i = 0; i < numZeros; i++) {
      nums[i] = 0;
    }
    
    for(i = 0; i < numOnes; i++) {
      nums[i + numZeros] = 1;
    }
    
    for(i = 0; i < nums.length - numZeros - numOnes; i++) {
      nums[i + numZeros + numOnes] = 2;
    }
  }

	public void sortColors_solution2(int[] nums) {
    if(nums.length <= 1) return;
    int i = 0;
    int j = 0;
    int n = nums.length-1;
    
    while(j <= n) {
      if(nums[j] == 0) {
        int temp = nums[i];
        nums[i++] = 0;
        nums[j] = temp;
      }
      else if(nums[j] == 2) {
        int temp = nums[n];
        nums[n--] = 2;
        nums[j] = temp;
        continue;
      }
      j++;
    }
  }
}
