package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE: LRU Cache (146) [MEDIUM]
 * 
 * use doubly linked list for O(1) removal
 * use hashmap for O(1) get and put
 * store more recent values at front of list
 * remove Least Recently Used from end of list
 * head and tail are dummy variables to help with removal edge cases
 */
public class LRUCache {
	DNode head;
  DNode tail;
  int capacity;
  Map<Integer, DNode> map;
  
  public LRUCache(int capacity) {
    this.head = new DNode(-1, -1);
    this.tail = new DNode(-1, -1);
    
    head.next = tail;
    tail.prev = head;
    
    this.capacity = capacity;
    this.map = new HashMap<>();
  }

  public int get(int key) {
    if(!map.containsKey(key)) return -1;
    DNode node = map.get(key);
    removeNode(node);
    addNode(node);
    return node.val;
  }

  public void put(int key, int value) {
    DNode node = map.get(key);
    if(node == null) {
      node = new DNode(key, value);
      addNode(node);
      map.put(key, node);
      if(map.size() > capacity) {
        DNode toBeDeleted = map.get(tail.prev.key);
        removeNode(toBeDeleted);
        map.remove(toBeDeleted.key);
      }
    }
    else {
      node.val = value;
      removeNode(node);
      addNode(node);
    }
  }
  
  private void addNode(DNode node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }
  
  private void removeNode(DNode node) {
    DNode prev = node.prev;
    DNode next = node.next;
    
    prev.next = next;
    next.prev = prev;
  }

}

class DNode {
  int key;
  int val;
  DNode prev;
  DNode next;
  
  public DNode(int key, int val) {
    this.key = key;
    this.val = val;
    this.prev = null;
    this.next = null;
  }
}