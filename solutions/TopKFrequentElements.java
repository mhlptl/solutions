package solutions;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * LEETCODE: Top K Frequent Elements (347) [MEDIUM]
 * 
 * use hashmap to get frequency of each number
 * then use heap to keep track of the K frequent elements (sort by value of hashmap)
 */
public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for(Integer num: nums) {
      int val = map.getOrDefault(num, 0) + 1;
      map.put(num, val);
    }
    
    Queue<Integer> pq = new PriorityQueue<Integer>((num1, num2) -> map.get(num1) - map.get(num2));
    
    for(Integer key: map.keySet()) {
      pq.add(key);
      if(pq.size() > k) pq.poll();
    }
    
    int[] result = new int[k];
    
    for(int i = 0; i < k; i++) {
      result[i] = pq.poll();
    }
    
    return result;
  }
}