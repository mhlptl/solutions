package solutions;

/**
 * LEETCODE: Counting Bits (338) [MEDIUM]
 * 
 * intervals: [2..3] [4..7] [8..15]
 * use previous interval to solve current interval
 * if even -> divide by 2
 * if odd -> previous index + 1
 */
public class CountingBits {
	public int[] countBits(int num) {
    int[] result = new int[num+1];
    
    for(int i = 1; i <= num; i++) {
      if((i % 2) == 1) {
        result[i] = result[i-1] + 1;
      }
      else {
        result[i] = result[i/2];
      }
    }
      
    return result;
  }
}
