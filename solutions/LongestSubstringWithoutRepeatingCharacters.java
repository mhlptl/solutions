package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * LEETCODE: Longest Substring Without Repeating Characters (3) [MEDIUM]
 * 
 * two pointer approach (sliding window)
 * 
 * if we have a character we've already seen
 * remove character at left pointer from set
 * and slide left pointer to the right
 * 
 * if we have a character we haven't seen
 * add character from right pointer to set
 * and slide right pointer to the right
 *  
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    
    int result = 0;
    int i = 0;
    int j = 0;
    int n = s.length();
    
    while(j < n) {
      char ch = s.charAt(j);
      if(set.contains(ch)) {
        set.remove(s.charAt(i));
        i++;
      }
      else {
        set.add(ch);
        j++;
        result = Math.max(j-i, result);
      }
    }
    
    return Math.max(j-i, result);
  }
}
