package solutions;

/**
 * LEETCODE: String to Integer (8) [MEDIUM]
 * 
 * 1. iterate passed whitespace
 * 2. check for sign
 * 3. iterate until EOL
 * if we see a nondigit break
 * else check for overflow and then add digit to result
 * return value with correct sign
 */
public class StringToInteger {
	public int myAtoi(String s) {
    boolean positive = true;
    int result = 0;
    
    int i = 0;
    int n = s.length();
    
    while(i < n && s.charAt(i) == ' ') {
      i++;
    }
    
    if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
      if(s.charAt(i) == '-') positive = false;
      i++;
    }
    
    while(i < n) {
      char ch = s.charAt(i);
      if(!Character.isDigit(ch)) {
        break;
      }
      int digit = ch - '0';
      if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
        return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      result = (result * 10) + digit;
      i++;
    }
    
    if(result == 0) return 0;
    return positive ? result : -1 * result;
  }
}
