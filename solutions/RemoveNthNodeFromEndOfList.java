package solutions;

import utils.ListNode;

/**
 * LEETCODE: Remove Nth Node from End of List (19) [MEDIUM]
 * 
 * move pointer1 up n spaces
 * now both pointers are separated by n spots
 * iterate both pointers until fast.next is null
 * slow.next should be pointing to the node to be deleted
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode result = new ListNode(-1);
    result.next = head;
    
    ListNode slow = result;
    ListNode fast = result;
    
    for(int i = 0; i < n; i++) {
      fast = fast.next;
    }
    
    while(fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    
    slow.next = slow.next.next;
    
    return result.next;
  }
}
