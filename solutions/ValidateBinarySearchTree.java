package solutions;

import utils.TreeNode;

/**
 * LEETCODE: Validate Binary Search Tree (98) [MEDIUM]
 * 
 * to validate a bst, we need to validate all the subtrees
 * therefore we need to check if each node is between the min and max values it can have
 * the max value a left node can have is equal to the value of its parent
 * the min value a right node can have is equal to the value of its parent
 */
public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
  }
  
  private boolean validate(TreeNode root, Integer min, Integer max) {
    if(root == null) return true;
    int val = root.val;
    if(min != null && min >= val) return false;
    if(max != null && max <= val) return false;
    
    return validate(root.left, min, val) && validate(root.right, val, max);
  }
}
