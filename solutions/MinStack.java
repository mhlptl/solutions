package solutions;
import java.util.Stack;
import java.util.Arrays;

/**
 * LEETCODE: Min Stack (155) [EASY]
 * 
 * use two stacks, one to keep track of all elements and one to keep track of min elements
 * push to minStack only if
 * 1. it is empty
 * 2. the current value is less than the top element in the minStack
 * only pop out of the minStack if the values at the top of the stack and the top of the minStack are equal
 */
public class MinStack {
  Stack<Integer> stack;
  Stack<Integer> minStack;
  
  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }

  public void push(int x) {
    if(minStack.isEmpty() || minStack.peek() >= x) {
      minStack.push(x);
    }
    stack.push(x);
  }

  public void pop() {
    if(!minStack.isEmpty() && Integer.compare(stack.peek(), minStack.peek()) == 0) {
      minStack.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
  
  private void print() {
    System.out.println("Reg: " + Arrays.toString(stack.toArray()));
    System.out.println("Min: " + Arrays.toString(minStack.toArray()));
  }
}
