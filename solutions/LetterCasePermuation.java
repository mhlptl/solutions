package solutions;
import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE: Letter Case Permuation (784) [MEDIUM]
 * 
 * TODO: writeup
 */
public class LetterCasePermuation {
	public List<String> letterCasePermutation(String S) {
    List<String> result = new ArrayList<>();
    permute(result, S.toCharArray(), 0);
    return result;
  }
  
  private void permute(List<String> res, char[] str, int index) {
    if(index == str.length) {
      res.add(String.valueOf(str));
      return;
    }
    if(index > str.length) return;
    if(Character.isDigit(str[index])) {
      permute(res, str, index+1);
      return;
    }
    
    str[index] = Character.toUpperCase(str[index]);
    permute(res, str, index+1);
    str[index] = Character.toLowerCase(str[index]);
    permute(res, str, index+1);
  }
}
