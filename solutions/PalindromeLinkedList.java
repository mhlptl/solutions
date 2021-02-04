package solutions;
import utils.ListNode;

/**
 * LEETCODE: Palindrome Linked List (234) [EASY]
 * 
 * iterative solution
 * using the fast/slow pointer, find the middle of the list
 * reverse the second half of the linked list
 * compare the first half and second half of the list
 * if they are the same, return true else return false
 * 
 * recursive solution
 * store the head in a pointer
 * recursively get to the end of the list
 * we can compare the pointer we stored to the node at the end of the list
 * if they are the same return true else return false
 */
public class PalindromeLinkedList {
	private ListNode frontPointer;
  
  public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    boolean iterative_sol = iterative_solver(head);
		frontPointer = head;
		boolean recursive_sol = recursive_solver(head);
    return recursive_sol;
	}
	
	private boolean iterative_solver(ListNode node) {
		ListNode middle = getMiddle(node);
    middle = reverse(middle);
    
    while(middle != null && node != null) {
      if(middle.val != node.val) return false;
      middle = middle.next;
      node = node.next;
    }
    return true;
	}
  
  private ListNode getMiddle(ListNode node) {
    ListNode slow = node;
    ListNode fast = node;
    
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    
    return slow;
  }
  
  private ListNode reverse(ListNode node) {
    if(node == null || node.next == null) return node;
    
    ListNode curr = node;
    ListNode prev = null;
    
    while(curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    
    return prev;
  }
  
  private boolean recursive_solver(ListNode recurHead) {
    if(recurHead != null) {
      if(!recursive_solver(recurHead.next)) return false;
      if(recurHead.val != frontPointer.val) return false;
      frontPointer = frontPointer.next;
    }
    return true;
  }
}