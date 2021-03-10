package solutions;

import java.util.LinkedList;
import java.util.Queue;
import utils.TreeNode;

/**
 * LEETCODE: Add One Row to Tree (623) [MEDIUM]
 * 
 * TODO: add writeup
 */
public class AddOneRowToTree {
	public TreeNode addOneRow_dfs(TreeNode root, int v, int d) {
    if(d == 1) {
      TreeNode node = new TreeNode(v);
      node.left = root;
      return node;
    }
    depth(root, 1, v, d);
    return root;
  }
  
  private TreeNode depth(TreeNode root, int depth, int v, int d) {
    if(root == null) return null;
    if(depth+1 == d) {
      TreeNode left = new TreeNode(v);
      TreeNode right = new TreeNode(v);
      left.left = root.left;
      right.right = root.right;
      root.left = left;
      root.right = right;
      return root;
    }
    root.left = depth(root.left, depth+1, v, d);
    root.right = depth(root.right, depth+1, v, d);
    return root;
  }

	public TreeNode addOneRow_bfs(TreeNode root, int v, int d) {
    if(d == 1) {
      TreeNode node = new TreeNode(v);
      node.left = root;
      return node;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode curr = root;
    queue.add(curr);
    int depth = 1;
    
    while(!queue.isEmpty()) {
      int n = queue.size();
      if(depth+1 == d) {
        for(int i = 0; i < n; i++) {
          TreeNode left = new TreeNode(v);
          TreeNode right = new TreeNode(v);
          TreeNode node = queue.poll();
          left.left = node.left;
          right.right = node.right;
          node.left = left;
          node.right = right;
        }
        break;
      }
      else {
        for(int i = 0; i < n; i++) {
          TreeNode node = queue.poll();
          if(node.left != null) queue.add(node.left);
          if(node.right != null) queue.add(node.right);
        }
      }
      depth++;
    }
    
    return root;
  }
}
