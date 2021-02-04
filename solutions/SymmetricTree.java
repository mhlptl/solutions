package solutions;
import utils.TreeNode;
import java.util.Queue;
import java.util.LinkedList;

/**
 * LEETCODE: Symmetric Tree (101) [EASY]
 * 
 * recursive solution
 * check the left and right subtrees to see if they are symmetric
 * the left subtrees left child should equal the right subtrees right child
 * the left subtrees right child should ewual the right subtrees left child
 * we are checking if the right and left children are equal before we do each recursive call
 * 
 * TODO: writeup for iterative
 * 
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		boolean recursive_sol = recursive_symmetric(root.left, root.right);
    boolean iterative_sol = iterative_symmetric(root);
    return iterative_sol;
  }
  
  private boolean recursive_symmetric(TreeNode left, TreeNode right) {
    if(left == null && right == null) return true;
    if(left == null || right == null) return false;
    if(left.val != right.val) return false;
    return recursive_symmetric(left.left, right.right) && recursive_symmetric(left.right, right.left);
  }
  
  private boolean iterative_symmetric(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    queue.add(root);
    
    while(!queue.isEmpty()) {
      TreeNode t1 = queue.poll();
      TreeNode t2 = queue.poll();
      
      if(t1 == null && t2 == null) continue;
      if((t1 == null || t2 == null) || t1.val != t2.val) return false;
      queue.add(t1.left);
      queue.add(t2.right);
      queue.add(t1.right);
      queue.add(t2.left);
    }
    return true;
  }
}
