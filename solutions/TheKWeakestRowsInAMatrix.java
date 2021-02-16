package solutions;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LEETCODE: The K Weakest Rows in a Matrix (1337) [EASY]
 * 
 * TODO: writeup
 */
public class TheKWeakestRowsInAMatrix {
	public int[] kWeakestRows(int[][] mat, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    
    Comparator<Integer> myComp = new Comparator<Integer>(){
      @Override
      public int compare(Integer t1, Integer t2) {
        if(Integer.compare(map.get(t1), map.get(t2)) == 0) {
          return t2 - t1;
        }
        return map.get(t2) - map.get(t1);
      }
    };
    Queue<Integer> pq = new PriorityQueue<>(myComp);
    
    for(int i = 0; i < mat.length; i++) {
      int numOnes = getLastOne(mat[i]);
      // System.out.println(numOnes);
      map.put(i, numOnes);
      pq.add(i);
      if(pq.size() > k) pq.poll();
    }
    
    int[] result = new int[k];
    
    for(int i = k-1; i >= 0; i--) {
      result[i] = pq.poll();
    }
    
    return result;
  }
  
  private int getLastOne(int[] nums) {
    int lo = 0;
    int hi = nums.length-1;
    
    while(lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if(nums[mid] == 0) {
        hi = mid-1;
      }
      else if(mid+1 < nums.length-1 && nums[mid+1] == 0) {
        return mid+1;
      }
      else {
        lo = mid+1;
      }
    }
    
    return lo;
  }
}
