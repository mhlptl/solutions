package solutions;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LEETCODE: Number of Islands (200) [MEDIUM]
 * 
 * dfs:
 * change current to '0' then traverse neighbors
 * 
 * bfs:
 * change current to '0' then for its neighbors
 * add to queue if equal to '1' and change its value to '0'
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int numIslands = 0;
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(grid[i][j] == '1') {
          // dfs(grid, i, j);
          bfs(grid, i, j);
          numIslands++;
        }
      }
    }
    
    return numIslands;
  }
  
  private void dfs(char[][] grid, int row, int col) {
    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;
    grid[row][col] = '0';
    dfs(grid, row+1, col);
    dfs(grid, row-1, col);
    dfs(grid, row, col+1);
    dfs(grid, row, col-1);
  }
  
  int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  
  private void bfs(char[][] grid, int row, int col) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{row, col});
    grid[row][col] = '0';
    
    while(!queue.isEmpty()) {
      int[] loc = queue.poll();
      for(int[] direction: directions) {
        int x = loc[0] + direction[0];
        int y = loc[1] + direction[1];
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') continue;
        queue.add(new int[]{x, y});
        grid[x][y] = '0';
      }
    }
  }
}
