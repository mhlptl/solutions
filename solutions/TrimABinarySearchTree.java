package solutions;
import utils.TreeNode;

/**
 * LEETCODE: Trim a Binary Search Tree (669) [MEDIUM]
 * 
 * TODO: need writeup
 */
public class TrimABinarySearchTree {
	public TreeNode trimBST(TreeNode root, int low, int high) {
    if(root == null) return null;
    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    if(root.val < low) return root.right;
    if(root.val > high) return root.left;
    return root;
  }
}
