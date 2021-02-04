package solutions;
import java.util.Map;
import java.util.HashMap;

/**
 * LEETCODE: Roman to Integer (13) [EASY]
 * 
 * store roman numeral -> integer conversion chart in hashmap for quick lookup
 * 
 * to convert from roman numeral to integer, start from the end of the string
 * if we see an 'I', 'X', or 'C', check the character to the right (if applicable)
 * if the character to the right and the current character form a roman numeral,
 * subtract the corresponding 'I', 'X', or 'C' from the result
 * else add converted roman numeral to result
 */
public class RomanToInteger {
	public int romanToInt(String s) {
    if(s == null || s.length() == 0) return 0;
    Map<Character, Integer> map = createMap();
    int result = 0;
    int n = s.length();
    
    for(int i = n-1; i >= 0; i--) {
      char ch = s.charAt(i);
      if(i+1 < n && ch == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
        result -= 1;
      }
      else if(i+1 < n && ch == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
        result -= 10;
      }
      else if(i+1 < n && ch == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
        result -= 100;
      }
      else {
        result += map.get(ch);
      }
    }
    return result;
  }
  
  private Map<Character, Integer> createMap() {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    return map;
  }
}
