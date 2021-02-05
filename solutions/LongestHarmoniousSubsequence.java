package solutions;
import java.util.Map;
import java.util.HashMap;

/**
 * LEETCODE: Longest Harmonious Subsequence (594) [EASY]
 * 
 * TODO: need writeup
 */
public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max = 0;
    
    for(Integer num: nums) {
      int val = map.getOrDefault(num, 0) + 1;
      map.put(num, val);
      
      if(map.containsKey(num-1)) {
        max = Math.max(map.get(num-1) + val, max);
      }
      if(map.containsKey(num+1)) {
        max = Math.max(map.get(num+1) + val, max);
      }
    }
    return max;
  }
}
