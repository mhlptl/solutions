package solutions;
import utils.TreeNode;

/**
 * LEETCODE: Maximum Depth of Binary Tree (104) [EASY]
 * 
 * recurse the tree from the left and right children
 * if we hit null nodes return 0
 * as we keep returning from the recursive calls, add 1 to the max of the two depths (left/right) returned
 */
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
}
