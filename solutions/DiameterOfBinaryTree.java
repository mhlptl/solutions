package solutions;
import utils.TreeNode;

/**
 * LEETCODE: Diameter of Binary Tree (543) [EASY]
 * 
 * TODO: need writeup
 */
public class DiameterOfBinaryTree {
	private int ans = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    if(root == null) return 0;
    depth(root);
    return ans;
  }
  
  private int depth(TreeNode node) {
    if(node == null) return 0;
    int left = depth(node.left);
    int right = depth(node.right);
    ans = Math.max(ans, left+right);
    return Math.max(left, right)+1;
  }
}
