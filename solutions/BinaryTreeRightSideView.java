package solutions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * LEETCODE: Binary Tree Right Side View (199) [MEDIUM]
 * 
 * use queue to do level order traversal
 * on each level, get the rightmost element (traverse each level until the end)
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
    if(root == null) return new ArrayList<>();
    
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode curr = root;
    queue.add(curr);
    
    while(!queue.isEmpty()) {
      int n = queue.size();
      while(n > 0) {
        curr = queue.poll();
        if(curr.left != null) queue.add(curr.left);
        if(curr.right != null) queue.add(curr.right);
        n--;
      }
      result.add(curr.val);
    }
    
    return result;
  }
}
