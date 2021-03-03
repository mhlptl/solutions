package solutions;
import java.util.PriorityQueue;

/**
 * LEETCODE: Kth Smallest Element in a Sorted Matrix (378) [MEDIUM]
 */
public class KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    int m = matrix.length;
    int n = matrix[0].length;
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        pq.offer(matrix[i][j]);
      }
    }
    
    while(k > 1) {
      pq.poll();
      k--;
    }
    
    return pq.poll();
  }
}
