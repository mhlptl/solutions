package solutions;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

/**
 * LEETCODE: Populating Next Right Pointers in Each Node (116) [MEDIUM]
 * 
 * use bfs to do level order traversal because of bfs, we will know the order of
 * each level set the next pointer of the current node to the item that is next
 * in the queue
 */
public class PopulatingNextRightPointersInEachNode {
  public TreeNode connect(TreeNode root) {
    if(root == null) return root;
    Queue<TreeNode> queue = new LinkedList<>();
    
    TreeNode curr = root;
    queue.add(root);
    
    while(!queue.isEmpty()) {
      
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        curr = queue.poll();
        curr.next = i+1 < size ? queue.peek() : null;
        if(curr.left != null) {
          queue.add(curr.left);
        }
        if(curr.right != null) {
          queue.add(curr.right);
        }
      }
    }
    
    return root;
  }
}
