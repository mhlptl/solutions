package solutions;

/**
 * LEETCODE: Longest Substring with At Least K Repeating Characters (395) [MEDIUM]
 * 
 * use divide and conquer
 * create frequency table
 * iterate string
 * if we see an invalid character, break string into smaller parts
 * left side -> from start until invalid character
 * right side -> from last invalid character to end
 * return the larger of the two
 * 
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
    return longestSubstring(s, 0, s.length(), k);
  }
  
  private int longestSubstring(String s, int start, int end, int k) {
    if(end < k) return 0;
    int[] frequency = new int[26];
    for(int i = start; i < end; i++) {
      frequency[s.charAt(i) - 'a']++;
    }
    
    for(int i = start; i < end; i++) {
      if(frequency[s.charAt(i) - 'a'] >= k) continue;
      int next = i+1;
      while(next < end && frequency[s.charAt(next) - 'a'] < k) {
        next++;
      }
      return Math.max(longestSubstring(s, start, i, k), longestSubstring(s, next, end, k));
    }
    return end - start;
  }
	
}