package solutions;
import utils.ListNode;

/**
 * LEETCODE: Intersection of Two Linked Lists (160) [EASY]
 * 
 * TODO: need writeup
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode currA = headA;
    ListNode currB = headB;
    
    while(currA != currB) {
      if(currA == null) {
        currA  = headB;
      }
      else {
        currA = currA.next;
      }
      if(currB == null) {
        currB = headA;
      }
      else {
        currB = currB.next;
      }
    }
    if(currA == currB) return currA;
    return null;
  }
}
