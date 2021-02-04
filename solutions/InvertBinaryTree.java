package solutions;
import utils.TreeNode;

/**
 * LEETCODE: Invert Binary Tree (226) [EASY]
 * 
 * to invert binary tree, start from bottom up
 * recurse until leaf nodes, then switch the nodes
 * then as we recurse back up, the tree will become inverted
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
    if(root == null) return null;
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
}
