package solutions;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Minimum Remove to Make Valid Parentheses (1249) [MEDIUM]
 * 
 * TODO: writeup
 */
public class MinimumRemoveToMakeValidParentheses {
  public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> removeIndex = new HashSet<>();
    
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(ch == '(') {
        stack.push(i);
      }
      else if(ch == ')') {
        if(stack.isEmpty()) {
          removeIndex.add(i);
        }
        else {
          stack.pop();
        }
      }
    }
    
    while(!stack.isEmpty()) {
      removeIndex.add(stack.pop());
    }
    
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < s.length(); i++) {
      if(!removeIndex.contains(i)) {
        sb.append(s.charAt(i));
      }
    }
    
    return sb.toString();
  }
}
