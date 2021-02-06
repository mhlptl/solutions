package solutions;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LEETCODE: Kth Largest Element in an Array (215) [MEDIUM]
 * 
 * use heap to keep track of the k largest elements
 * since we keep track of the k largest elements
 * we can return the top element in the heap
 */
public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
    Queue<Integer> pq = new PriorityQueue<>();
    
    for(int num: nums) {
      pq.add(num);
      if(pq.size() > k) pq.poll();
    }
    return pq.poll();
  }
}
