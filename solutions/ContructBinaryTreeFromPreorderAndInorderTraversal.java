package solutions;
import java.util.HashMap;
import java.util.Map;
import utils.TreeNode;

/**
 * LEETCODE: Contruct Binary Tree From Preorder And Inorder Traversal (105) [MEDIUM]
 * 
 * use preorder to get which node to create
 * use inorder to find which nodes belong in the left/right subtree
 */
public class ContructBinaryTreeFromPreorderAndInorderTraversal {
  private int[] preorder;
  private int[] inorder;
  private Map<Integer, Integer> map;
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;
    this.map = storeIndex();
    
    return buildTree(0, 0, preorder.length-1);
  }
  
  private TreeNode buildTree(int index, int open, int close) {
    if(open > close || index >= preorder.length) return null;
    
    TreeNode node = new TreeNode(preorder[index]);
    int inorderIndex = map.get(node.val);
    
    node.left = buildTree(index+1, open, inorderIndex-1);
    node.right = buildTree(index + inorderIndex - open + 1, inorderIndex+1, close);
    
    return node;
    
  }
  
  private Map<Integer, Integer> storeIndex() {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return map;
  }
	
}