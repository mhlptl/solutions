package utils;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;

	public TreeNode() {
		this.val = 0;
		this.left = null;
		this.right = null;
		this.next = null;
	}

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.next = null;
	} 

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = null;
	}
}
