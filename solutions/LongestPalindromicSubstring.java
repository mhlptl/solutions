package solutions;

/**
 * LEETCODE: Longest Palindromic Substring (5) [MEDIUM]
 * 
 * expand around center
 * do this for each character
 * expand around center with the center being the same letter
 * expand around center with the center being the letter at index i and index i+1
 * to get the start -> currentIndex - (len - 1) / 2;
 * to get the end -> currentIndex + (len / 2);
 * 
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
    if(s == null || s.length() == 0) return "";
    
    int n = s.length();
    int left = 0;
    int right = 0;
    int maxLen = 0;
    for(int i = 0; i < n; i++) {
      int expandOdd = expand(s, i, i);
      int expandEven = expand(s, i, i+1);
      int len = Math.max(expandOdd, expandEven);
      
      if(len > maxLen) {
        left = i - (len - 1) / 2;
        right = i + len / 2;
        maxLen = len;
      }
      
    }
    return s.substring(left, right + 1);
  }
  
  // expand outwards (i.e. expand from center)
  private int expand(String str, int l, int r) {
    while(l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
      l--;
      r++;
    }
    
    return r - l - 1;
  }
}
