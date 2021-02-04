package solutions;
import java.util.Stack;

/**
 * LEETCODE: Valid Parentheses (20) [EASY]
 * 
 * using a stack we can check to see if the parentheses are balanced
 * if we have a closing parentheses, the previous item on the stack should be an opening parentheses
 * we check if the opening and closing parentheses have the same style
 * at the end of our loop, the stack should be empty if the parentheses were balanced
 */
public class ValidParentheses {
	public boolean isValid(String s) {
    if(s == null || s.length() == 0 || s.length() % 2 == 1) return false;
    
    Stack<Character> stack = new Stack<Character>();
    int n = s.length();
    
    for(int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if(ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      }
      else {
        if(stack.isEmpty()) return false;
        char fromStack = stack.pop();
        if((fromStack == '(' && ch != ')') || (fromStack == '[' && ch != ']') || (fromStack == '{' && ch != '}')) return false;
      }
    }
    return stack.isEmpty();
  }
}
