package solutions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * LEETCODE: Binary Tree Level Order Traversal (102) [MEDIUM]
 * 
 * use queue to do level order traversal
 * get size of queue to distinguish levels
 * 
 * TODO: recursive solution	
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    
    queue.add(root);
    
    while(!queue.isEmpty()) {
      int n = queue.size();
      List<Integer> level = new ArrayList<>();
      
      for(int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      }
      
      result.add(new ArrayList<>(level));
    }
    
    return result;
  }
}
