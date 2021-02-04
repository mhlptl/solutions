package solutions;
import utils.ListNode;

/**
 * LEETCODE: Linked List Cycle (141) [EASY]
 * 
 * use two pointers to keep space complexity to O(1)
 * have slow pointer and fast pointer
 * why? if there is a cycle the fast pointer will catch up to the slow pointer
 * for every n nodes the slow pointer has covered, the fast pointer has covered 2n nodes
 * if there is a cycle, they will intersect at the nth node (not necessarily where the cycle starts)
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
    if(head == null || head == null) return false;
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) return true;
    }
    
    return false;
  }
}
