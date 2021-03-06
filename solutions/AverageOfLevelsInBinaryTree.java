package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * LEETCODE: Average of Levels in Binary Tree (637) [EASY]
 * 
 * use bfs to keep track of levels
 * for each level, sum up the node values
 * then divide by the size of the level
 */
public class AverageOfLevelsInBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    
    TreeNode curr = root;
    queue.offer(curr);
    
    while(!queue.isEmpty()) {
      int n = queue.size();
      double sum = 0;
      for(int i = 0; i < n; i++) {
        curr = queue.poll();
        sum += curr.val;
        if(curr.left != null) queue.offer(curr.left);
        if(curr.right != null) queue.offer(curr.right);
      }
      result.add(sum / n);
    }
    
    return result;
  }
}
