package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LEETCODE: Shortest Distance to a Character (821) [EASY]
 * 
 * solution 1:
 * use queue to implement BFS
 * uses O(N) space
 * 
 * solution 2:
 * go left to right storing shortest distance
 * go right to left storing shortest distance
 * 
 */
public class ShortestDistanceToACharacter {
	
	public int[] shortestToChar_solution1(String s, char c) {
    int n = s.length();
    int[] distance = new int[n];
    Arrays.fill(distance, n);
    
    Queue<Integer> queue = new LinkedList<>();
    
    for(int i = 0; i < n; i++) {
      char curr = s.charAt(i);
      if(curr == c) {
        queue.add(i);
        distance[i] = 0;
      } 
    }
    
    while(!queue.isEmpty()) {
      int index = queue.poll();
      if(index-1 >= 0 && distance[index-1] > (distance[index]+1)) {
        distance[index-1] = distance[index]+1;
        queue.add(index-1);
      }
      if(index+1 < n && distance[index+1] > (distance[index]+1)) {
        distance[index+1] = distance[index]+1;
        queue.add(index+1);
      }
    }
    
    return distance;
  }

	public int[] shortestToChar_solution2(String s, char c) {
    int n = s.length();
    int[] distance = new int[n];
    Arrays.fill(distance, n);
    
    for(int i = 0; i < n; i++) {
      if(s.charAt(i) == c) distance[i] = 0;
    }
    
    for(int i = 0; i < n-1; i++) {
      if(distance[i] != n) {
        distance[i+1] = Math.min(distance[i+1], distance[i]+1); 
      }
    }
    
    for(int i = n-1; i > 0; i--) {
      if(distance[i] != n) {
        distance[i-1] = Math.min(distance[i-1], distance[i]+1);
      }
    }
    
    return distance;
  }
}
