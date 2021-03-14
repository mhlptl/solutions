package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE: Decode Ways (91) [MEDIUM]
 * 
 * using memoization, we can save time 
 * if we see a mapping we've already seen before
 */
public class DecodeWays {
	private Map<Integer, Integer> mapping;
  
  public int numDecodings(String s) {
    this.mapping = new HashMap<>();
    return decode(s, 0);
  }
  
  private int decode(String str, int index) {
    if(mapping.containsKey(index)) {
      return mapping.get(index);
    }
    if(index == str.length()) {
      return 1;
    }
    
    if(str.charAt(index) == '0') {
      return 0;
    }
    
    int numWays = decode(str, index+1);
    if(index+2 <= str.length() && Integer.parseInt(str.substring(index, index+2)) <= 26) {
      numWays += decode(str, index+2);
    }
    
    mapping.put(index, numWays);
    return numWays;
  }
}
