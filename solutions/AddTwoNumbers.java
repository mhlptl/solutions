package solutions;

import utils.ListNode;

/**
 * LEETCODE: Add Two Numbers (2) [MEDIUM]
 * 
 * if either node becomes null, replace with the number 0
 * loop until both nodes become null
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(-1);
    ListNode temp = result;
    
    int carry = 0;
    
    while(l1 != null || l2 != null) {
      int l1_val = l1 == null ? 0 : l1.val;
      int l2_val = l2 == null ? 0 : l2.val;
      
      int sum = l1_val + l2_val + carry;
      temp.next = new ListNode(sum % 10);
      carry = sum / 10;
      
      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;
      temp = temp.next;
    }
    
    if(carry > 0) {
      temp.next = new ListNode(carry);
    }
    
    return result.next;
  }
}
