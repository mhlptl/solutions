package solutions;
import utils.ListNode;

/**
 * LEETCODE: Sort List (148) [MEDIUM]
 * 
 * MERGESORT
 * split list into half
 * keep splitting until the list has either zero or one elements (using recursion)
 * merge in sorted order (21. Merge Two Sorted Lists)
 * recursive call will keep returning until the whole list is sorted
 */
public class SortList {
	public ListNode sortList(ListNode head) {
    return split(head);
  }
  
  private ListNode split(ListNode node) {
    if(node == null || node.next == null) return node;
    
    ListNode prev = null;
    ListNode slow = node;
    ListNode fast = node;
    
    while(fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    
    if(slow != null) prev.next = null;
    
    ListNode left = split(node);
    ListNode right = split(slow);
    
    ListNode mergedList = merge(left, right);
    
    return mergedList;
    
  }
  
  private ListNode merge(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    
    ListNode res = new ListNode(-1);
    ListNode temp = res;
    
    while(l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
      }
      else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    
    if(l1 != null) {
      temp.next = l1;
    }
    if(l2 != null) {
      temp.next = l2;
    }
    
    return res.next;
  }
}
