package solutions;

/**
 * LEETCODE: Count and Say (38) [EASY]
 * 
 * do recursive call until n == 1
 * as we return from the recursive call
 * keep converting the result
 * 
 * how to convert:
 * find number of times the same letter appears next to itself
 * append frequency first and then the letter
 * repeat until end of string
 */
public class CountAndSay {
	public String countAndSay(int n) {
    if(n == 1) return "1";
    return convert(countAndSay(n-1));
  }
  
  private String convert(String str) {
    StringBuilder sb = new StringBuilder();
    
    int freq = 1;
    int i = 0;
    int n = str.length();
    
    while(i < n) {
      if(i+1 == n || str.charAt(i) != str.charAt(i+1)) {
        sb.append(freq);
        sb.append(str.charAt(i));
        freq = 1;
      }
      else {
        freq++;
      }
      i++;
    }
    
    return sb.toString();
  }
}
