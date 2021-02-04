package solutions;
import utils.ListNode;

/**
 * LEETCODE: Merge Two Sorted Lists (21) [EASY]
 * 
 * merging using iteration:
 * add smaller number to result list
 * iterate the list that has the smaller number
 * keep doing this until one list is null
 * if one of the list is not null, attach it to the end of the result list
 * 
 * merging using recursion:
 * set the next of the the list with the smaller list to the return value of the recursive call
 * in the recursive call, iterate the list with the smaller value
 * return the corressponding list
 */
public class MergeTwoSortedLists {
	public ListNode mergeSortedLists(ListNode l1, ListNode l2) {
		ListNode iterative_sol = iteration_merge(l1, l2);
		ListNode recursive_sol = recurse_merge(l1, l2);
		return iterative_sol;
	}

  private ListNode iteration_merge(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode result = new ListNode(-1);
    ListNode temp = result;
    
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
    
    if(l1 != null) temp.next = l1;
    if(l2 != null) temp.next = l2;
    
    return result.next;
  }
  
  private ListNode recurse_merge(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    if(l1.val < l2.val) {
      l1.next = recurse_merge(l1.next, l2);
      return l1;
    }
    else {
      l2.next = recurse_merge(l1, l2.next);
      return l2;
    }
  }
}