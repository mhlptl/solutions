package solutions;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import utils.TreeNode;

/**
 * LEETCODE: Binary Tree Inorder Traversal (94) [MEDIUM]
 * 
 * iterative inorder traversal (Left, Node, Right)
 * use stack to keep track of nodes to be visited
 * add nodes to left and go left
 * make node equal to its right
 * do this until node is null and stack is empty
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
    if(root == null) return new ArrayList<Integer>();
    return inorder(root);
  }
  
  private List<Integer> inorder(TreeNode node) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    
    while(node != null || !stack.isEmpty()) {
      
      while(node != null) {
        stack.add(node);
        node = node.left;
      }
      
      node = stack.pop();
      result.add(node.val);
      node = node.right;
    }
    
    return result;
  }
}
