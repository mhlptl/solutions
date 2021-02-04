package solutions;

/**
 * LEETCODE: Longest Common Prefix (14) [EASY]
 * 
 * use the first string in the array
 * compare that string to the rest of the strings in the array
 * check one character at a time, but for each of the strings,
 * before moving onto the next character
 */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0) return "";

    String str = strs[0];

    for(int i = 0; i < str.length(); i++) {
      for(int j = 1; j < strs.length; j++) {
        if(i >= strs[j].length() || strs[j].charAt(i) != str.charAt(i)) return str.substring(0, i);
      }
    }

    return str;
  }	
}
