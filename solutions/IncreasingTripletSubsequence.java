package solutions;

/**
 * LEETCODE: Increasing Triplet Subsequence (334) [MEDIUM]
 * 
 * find 3 minimum numbers which form an increasing subsequence
 * if we find a number less than one of our minimum numbers, change it to that number
 * finding third number is redundant
 */
public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
    Integer min1 = null;
    Integer min2 = null;
    Integer min3 = null;

    for(int num: nums) {
      if(min1 == null || num <= min1) {
        min1 = num;
      }
      else if(min2 == null || num <= min2) {
        min2 = num;
      }
      else if(min3 == null || num <= min3) {
        min3 = num;
      }

      if(min1 != null && min2 != null && min3 != null && min1 < min2 && min2 < min3) return true;
    }

    return false;
  }
}
