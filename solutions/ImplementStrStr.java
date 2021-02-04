package solutions;

/**
 * LEETCODE: Implement strStr() (28) [EASY]
 * 
 * to check if the needle is the haystack
 * at each index of the haystack, check if the needle is present
 * if the needle is present return true, else return false
 */
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
    if(haystack.length() < needle.length()) return -1;
    if(needle.length() == 0) return 0;
    
    int m = haystack.length();
    int n = needle.length();

    for(int i = 0; i < m - n + 1; i++) {
      if(found(haystack, needle, i)) return i;
    }
    return -1;
  }
  
  private boolean found(String haystack, String needle, int offset) {
    for(int i = 0; i < needle.length(); i++) {
      if(needle.charAt(i) != haystack.charAt(i + offset)) return false;
    }
    return true;
  }
}
