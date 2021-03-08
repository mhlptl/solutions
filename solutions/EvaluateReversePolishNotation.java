package solutions;

import java.util.Stack;

/**
 * LEETCODE: Evaluate Reverse Polish Notation (150) [MEDIUM]
 * 
 * if the token is not an operator, push it onto the stack
 * else pop two operands off the stack, do the current operation
 * then push the result onto the stack
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
    Stack<Integer> operands = new Stack<>();
    
    for(String token: tokens) {
      if(token.equals("*")) {
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        operands.push(operand1 * operand2);
      }
      else if(token.equals("/")) {
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        operands.push(operand1 / operand2);
      }
      else if(token.equals("+")) {
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        operands.push(operand1 + operand2);
      }
      else if(token.equals("-")) {
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        operands.push(operand1 - operand2);
      }
      else {
        operands.push(Integer.parseInt(token));
      }
    }
    
    return operands.peek();
  }
}
