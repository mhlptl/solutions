package solutions;

import utils.ListNode;

/**
 * LEETCODE: Swapping Nodes in a Linked List (1721) [MEDIUM]
 * 
 * find node k spots away from front
 * find node k spots away from tail (same logic as question: Remove Nth Node from End of List)
 * switch the values at both nodes
 */
public class SwappingNodesInaLinkedList {
	public ListNode swapNodes(ListNode head, int k) {
    ListNode curr = head;
    
    ListNode left = curr;
    
    // left should be k away from front
    for(int i = 1; i < k; i++) {
      left = left.next;
    }
    
    ListNode right = curr;
    ListNode fast = curr;
    
    // move fast pointer up by k moves
    for(int i = 0; i < k; i++) {
      fast = fast.next;
    }
    
    // right should be k away from end
    while(fast != null) {
      right = right.next;
      fast = fast.next;
    }
    
    int temp = left.val;
    left.val = right.val;
    right.val = temp;
    
    return head;
  }
}
