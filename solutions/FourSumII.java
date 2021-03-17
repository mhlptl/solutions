package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE: 4Sum II (454) [MEDIUM]
 * 
 * iterate first two lists and put sum in hashmap w/ the frequency of that sum
 * iterate last two lists and if -sum is in hashmap, add the frequency to result
 */
public class FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    for(int i = 0; i < A.length; i++) {
      for(int j = 0; j < B.length; j++) {
        int sum = A[i] + B[j];
        int val = map.getOrDefault(sum, 0) + 1;
        map.put(sum, val);
      }
    }
    
    for(int i = 0; i < C.length; i++) {
      for(int j = 0; j < D.length; j++) {
        int sum = -(C[i] + D[j]);
        if(map.containsKey(sum)) {
          result += map.get(sum);
        }
      }
    }
    
    return result;
  }
}
