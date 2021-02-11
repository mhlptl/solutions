package solutions;
import java.util.Stack;

/**
 * LEETCODE: Basic Calculator II (227) [MEDIUM]
 * 
 * TODO: add writeup
 */
public class BasicCalculatorII {
	public int calculate(String s) {
    Stack<Integer> operands = new Stack<>();
    int num = 0;
    int n = s.length();
    char operator = '+';
    
    for(int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if(Character.isDigit(ch)) {
        num = (num * 10) + (ch - '0');
      }
      if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i+1 == n) {
        if(operator == '*') {
          operands.push(operands.pop() * num);
        }
        else if(operator == '/') {
          operands.push(operands.pop() / num);
        }
        else if(operator == '+') {
          operands.push(num);
        }
        else if(operator == '-') {
          operands.push(-num);
        }
        operator = ch;
        num = 0;
      }
    }
    
    int result = 0;
    while(!operands.isEmpty()) {
      result += operands.pop();
    }
    return result;
  }
}
