package solutions;
import utils.TreeNode;

/**
 * LEETCODE: Convert Sorted Array to Binary Search Tree (108) [EASY]
 * 
 * to create tree, use divide and conquer to create left and right subtrees
 * when returning from the recursive calls, set nodes left and right pointers to the return values
 * return node to return the current node, until we return the root node
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) return null;
		return createTree(nums, 0, nums.length-1);
	}

	private TreeNode createTree(int[] nums, int lo, int hi) {
		if(lo > hi) return null;
		int mid = lo + (hi - lo) / 2;

		TreeNode node = new TreeNode(nums[mid]);

		TreeNode left = createTree(nums, lo, mid-1);
		TreeNode right = createTree(nums, mid+1, hi);
	
		node.left = left;
		node.right = right;

		return node;
	}
}
