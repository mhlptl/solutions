package solutions;

import utils.TreeNode;

/**
 * LEETCODE: Lowest Common Ancestor of a Binary Search TREE (235) [EASY]
 * 
 * because of the BST constraints
 * if p and q are less than the root, search left subtree
 * if p and q are greather than the root, search right subtree
 * else return the root
 */
public class LowestCommonAncestorOfABinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;
    if((p.val <= root.val && q.val >= root.val) || p.val >= root.val && q.val <= root.val) return root;
    if(p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    return lowestCommonAncestor(root.right, p, q);
  }
}
