package solutions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LEETCODE: Letter Combinations of a Phone Number (17) [MEDIUM]
 * 
 * store mappings in map
 * to create combinations use backtracking
 * add to list if sizes match
 * get letter mapping for current number
 * loop through letters
 * add to string, call function with index+1, remove from string
 */
public class LetterCombinationsOfAPhoneNumber {
	private Map<Character, String> map;
  
  public List<String> letterCombinations(String digits) {
    if(digits == null || digits.length() == 0) return new ArrayList<>();
    createMap();
    List<String> result = new ArrayList<>();
    createCombinations(result, new StringBuilder(), digits, 0);
    return result;
  }
  
  private void createMap() {
    map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
  }
  
  private void createCombinations(List<String> res, StringBuilder sb, String digits, int index) {
    if(sb.length() == digits.length()) {
      res.add(sb.toString());
      return;
    }
    if(index > digits.length()) return;
    
    String letters = map.get(digits.charAt(index));
    
    for(int i = 0; i < letters.length(); i++) {
      sb.append(letters.charAt(i));
      createCombinations(res, sb, digits, index+1);
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
