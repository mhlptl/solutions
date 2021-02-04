package solutions;
import java.util.List;
import java.util.ArrayList;

/**
 * LEETCODE: Generate Parentheses (22) [MEDIUM]
 * 
 * to generate valid parentheses
 * the number of open parentheses need to be less than n
 * and the number of closed parentheses need to be less than the number of open parentheses
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    generateParens(result, new StringBuilder(), 0, 0, n);
    return result;
  }
  
  private void generateParens(List<String> res, StringBuilder sb, int open, int close, int n) {
    if(close == n) {
      res.add(sb.toString());
      return;
    }
    if(open < n) {
      generateParens(res, sb.append('('), open+1, close, n);
      sb.deleteCharAt(sb.length()-1);
    }
    if(open > close) {
      generateParens(res, sb.append(')'), open, close+1, n); 
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
