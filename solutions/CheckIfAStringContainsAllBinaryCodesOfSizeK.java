package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * LEETCODE: Check if a String Contains All Binary Codes of Size K (1461) [MEDIUM]
 * 
 * check if the string contains 2^k unique substrings of size k 
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
  public boolean hasAllCodes(String s, int k) {
    Set<String> seen = new HashSet<>();
    
    int i = 0;
    int n = s.length();
    
    for(int j = 0; j < n; j++) {
      if(j - i + 1 == k) {
        String string = s.substring(i, j+1);
        if(!seen.contains(string)) {
          seen.add(string);
        }
        i++;
      }
    }
    
    return seen.size() == Math.pow(2, k);
  }
}
