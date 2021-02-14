package solutions;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LEETCODE: Shortest Path in Binary Matrix (1091) [MEDIUM]
 * 
 * TODO: writeup and simplify solution
 */
public class ShortestPathInBinaryMatrix {
	  
  int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
  
  public int shortestPathBinaryMatrix(int[][] grid) {
    if(grid[0][0] == 1) return -1;
    Set<String> seen = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    int m = grid.length;
    int n = grid[0].length;
    
    queue.add(encode(0, 0, 1));
    seen.add(encode(0, 0));
    
    while(!queue.isEmpty()) {
      String curr = queue.poll();
      int[] location = decode(curr);
      if(location[0] == m-1 && location[1] == n-1) {
        return location[2];
      }
      for(int[] direction: directions) {
        int r = direction[0] + location[0];
        int c = direction[1] + location[1];
        if(r < 0 || c < 0 || r >= m || c >= n || seen.contains(encode(r, c)) || grid[r][c] == 1) continue;
        queue.add(encode(r, c, location[2]+1));
        seen.add(encode(r, c));
      }
    }
    return -1;
  }
  
  private String encode(int row, int col, int depth) {
    return row + ":" + col + ":" + depth;
  }
  
  private String encode(int row, int col) {
    return row + ":" + col;
  }
  
  private int[] decode(String str) {
    int[] location = new int[3];
    String[] strs = str.split(":");
    location[0] = Integer.parseInt(strs[0]);
    location[1] = Integer.parseInt(strs[1]);
    location[2] = Integer.parseInt(strs[2]);
    return location;
  }
}
