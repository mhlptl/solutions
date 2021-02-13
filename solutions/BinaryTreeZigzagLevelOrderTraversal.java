package solutions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * LEETCODE: Binary Tree Zigzag Level Order Traversal (103) [MEDIUM]
 * 
 * do bfs normally
 * if have to add to list backwards, add it to the front of the list
 * else add it to the end of the list
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean backwards = false;
    
    while(!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for(int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();
        if(backwards) level.add(0, curr.val);
        else level.add(curr.val);
        if(curr.left != null) queue.add(curr.left);
        if(curr.right != null) queue.add(curr.right);
      }
      result.add(new ArrayList<>(level));
      backwards = !backwards;
    }
    
    return result;
  }
}
