package solutions;
import utils.Node;

/**
 * LEETCODE: Copy List with Random Pointer (138) [MEDIUM]
 * 
 * set each original nodes next pointer to the copy
 * set the random of each copy to the original nodes random pointers next
 * separate lists into original and copy
 */
public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
    if(head == null) return head;
    Node curr = head;
    
    while(curr != null) {
      Node copy = new Node(curr.val);
      copy.next = curr.next;
      curr.next = copy;
      curr = copy.next;
    }
    
    curr = head;
    
    while(curr != null) {
      Node copy = curr.next;
      if(curr.random != null) copy.random = curr.random.next;
      curr = copy.next;
    }
    
    Node result = new Node(-1);
    Node temp = result;
    
    curr = head;
    
    while(curr != null) {
      Node copy = curr.next;
      temp.next = copy;
      temp = temp.next;
      curr.next = copy.next;
      curr = curr.next;
    }

    return result.next;
  }
}