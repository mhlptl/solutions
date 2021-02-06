package solutions;
import utils.ListNode;

/**
 * LEETCODE: Odd Even Linked List (328) [MEDIUM]
 * 
 * use pointers to keep track of the odd and even node positions
 * 
 * TODO: simplify solution
 */
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode evenHead = new ListNode(-1);
    ListNode oddHead = new ListNode(-1);
    
    ListNode evenTemp = evenHead;
    ListNode oddTemp = oddHead;
    
    while(head != null) {
      oddTemp.next = head;
      oddTemp = oddTemp.next;
      evenTemp.next = oddTemp.next;
      evenTemp = evenTemp.next;
      if(evenTemp == null) break;
      head = evenTemp.next;
    }
    
    oddTemp.next = evenHead.next;
    return oddHead.next;
  }
}
