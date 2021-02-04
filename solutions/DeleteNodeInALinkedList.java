package solutions;
import utils.ListNode;

/**
 * LEETCODE: Delete Node in a Linked List (237) [EASY]
 * 
 * set the current node value to the next node's value
 * set the current node's next to the next node's next
 */
public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
