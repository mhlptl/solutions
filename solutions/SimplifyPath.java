package solutions;
import java.util.Stack;

/**
 * LEETCODE: Simplify Path (71) [MEDIUM]
 * 
 * use stack to keep track of directories seen
 * if we see "/" check if the directory is valid
 * if we see ".." remove last item on stack (if applicable)
 * if we see "." don't do anything
 * 
 * TODO: simplify solution
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
    Stack<String> stack = addToStack(path);
    StringBuilder result = new StringBuilder();
    
    while(!stack.isEmpty()) {
      result.insert(0, stack.pop());
      result.insert(0, '/');
    }
    if(result.length() == 0) result.append('/');
    return result.toString();
  }
  
  private Stack<String> addToStack(String path) {
    Stack<String> stack = new Stack<String>();
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < path.length(); i++) {
      char ch = path.charAt(i);
      if(ch == '/') {
        String temp = sb.toString();
        if(temp.equals("..")) {
          if(!stack.isEmpty()) stack.pop();
        }
        else if(!temp.equals(".") && temp.length() > 0) {
          stack.push(temp);
        }
        sb = new StringBuilder();
      }
      else {
        sb.append(ch); 
      }
    }
    if(sb.toString().equals("..")) {
      if(!stack.isEmpty()) stack.pop();
    }
    else if(!sb.toString().equals(".") && sb.length() > 0) stack.push(sb.toString());
    return stack;
  }
}