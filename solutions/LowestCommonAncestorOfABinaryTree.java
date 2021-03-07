package solutions;

import utils.TreeNode;

/**
 * LEETCODE: Lowest Common Ancestor of a Binary Tree (236) [MEDIUM]
 * 
 * traverse tree until we find p and q
 * if we find p or q, return it
 * keep returning until the root node
 * if both left and right subtrees are not null (p or q is in the left or right subtree)
 * it will return the lowest common ancestor
 */
public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;
    if(root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    
    if(left != null && right != null) return root;
    if(left == null) return right;
    return left;
  }
}
