package solutions;
import utils.ListNode;

/**
 * LEETCODE: Reverse Linked List (206) [EASY]
 * 
 * TODO: writeup
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
    if(head == null) return head;
    ListNode recursive_sol = reverse_recurse(head);
		ListNode iterative_sol = reverse_iterative(head);
		return recursive_sol;
  }

  private ListNode reverse_recurse(ListNode curr) {
    if(curr == null || curr.next == null) return curr;
    ListNode newHead = reverse_recurse(curr.next);

    curr.next.next = curr;
    curr.next = null;
    return newHead;
  }

  private ListNode reverse_iterative(ListNode curr) {
    if(curr == null || curr.next == null) return curr;

    ListNode prev = null;

    while(curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
