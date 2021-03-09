package solutions;

/**
 * LEETCODE: Remove Palindromic Subsequences (1332) [EASY]
 * 
 * brainteaser
 * 
 * if the string itself is a palidrome, it would take one move
 * otherwise because we know it only contains two letters
 * and we could take a subsequence, remove all a's and then remove all b's
 * therefore it would take two moves to create an empty string
 * 
 */
public class RemovePalindromicSubsequences {
  public int removePalindromeSub(String s) {
    if(s == null || s.length() == 0) return 0;
    if(isPalindrome(s)) return 1;
    return 2;
  }
  
  private boolean isPalindrome(String s) {
    int lo = 0;
    int hi = s.length()-1;
    
    while(lo <= hi) {
      if(s.charAt(lo++) != s.charAt(hi--)) return false;
    }
    
    return true;
  }
}
