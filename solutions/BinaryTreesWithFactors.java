package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE: Binary Trees with Factors (823) [MEDIUM]
 * 
 * TODO: writeup
 */
public class BinaryTreesWithFactors {
	public int numFactoredBinaryTrees(int[] arr) {
    Arrays.sort(arr);
    int mod = 1000000007;
    Map<Integer, Long> map = new HashMap<>();
    long result = 0;
    for(int num: arr) {
      map.put(num, 1L);
    }
    
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < i; j++) {
        if(arr[i] % arr[j] == 0) {
          map.put(arr[i], (map.get(arr[i]) + map.get(arr[j]) * map.getOrDefault(arr[i] / arr[j], 0L)) % mod);
        }
      }
      result = (result + map.get(arr[i])) % mod;
    }
    
    return (int) result;
  }
}
