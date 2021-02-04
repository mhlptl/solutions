package solutions;
import java.util.Stack;
import utils.TreeNode;

/**
 * LEETCODE: Kth Smallest Element in a BST (230) [MEDIUM]
 * 
 * to get the kth smallest element use inorder traversal
 * when k is equal to zero, we have our kth smallest element
 */
public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
    if(root == null) return -1;
    return inorder(root, k);
  }
  
  private int inorder(TreeNode node, int k) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    while(!stack.isEmpty() || node != null) {
      while(node != null) {
        stack.add(node);
        node = node.left;
      }
      
      node = stack.pop();
      k--;
      if(k == 0) return node.val;
      node = node.right;
    }
    
    return -1;
  }
}