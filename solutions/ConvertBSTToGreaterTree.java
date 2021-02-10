package solutions;
import utils.TreeNode;

/**
 * LEETCODE: Convert BST to Greater Tree (538) [MEDIUM]
 * 
 * do inorder traversal going from the right to left
 */
public class ConvertBSTToGreaterTree {
  private int sum = 0;
  public TreeNode convertBST(TreeNode root) {
    if(root == null) return root;
    convertBST(root.right);
    sum += root.val;
    root.val = sum;
    convertBST(root.left);
    return root;
  }	
}
