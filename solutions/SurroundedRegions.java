package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LEETCODE: Surrounded Regions (130) [MEDIUM]
 * 
 * bfs:
 * only look at the borders, add to queue and to seen
 * any items in seen are attached to the borders, so we don't change them to 'X'
 * 
 * dfs:
 * only look at the borders
 * any items that are 'O' get changed to 'X' (not attached to border) 
 * any items changed to '.' get changed to 'O' (attached to border)
 */
public class SurroundedRegions {
  
  private int numCols;
  private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  
  public void solve_BFS(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    this.numCols = n;
    
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> seen = new HashSet<>();
    
    for(int i = 0; i < m; i++) {
      if(board[i][0] == 'O') {
        int encodedPos = encode(i, 0);
        queue.add(encodedPos);
        seen.add(encodedPos);
      }
      if(board[i][n-1] == 'O') {
        int encodedPos = encode(i, n-1);
        queue.add(encodedPos);
        seen.add(encodedPos);
      }
    }
    
    for(int i = 0; i < n; i++) {
      if(board[0][i] == 'O') {
        int encodedPos = encode(0, i);
        queue.add(encodedPos);
        seen.add(encodedPos);        
      }
      if(board[m-1][i] == 'O') {
        int encodedPos = encode(m-1, i);
        queue.add(encodedPos);
        seen.add(encodedPos);        
      }
    }
    
    while(!queue.isEmpty()) {
      int encodedPos = queue.poll();
      int col = encodedPos % numCols;
      int row = (encodedPos - col) / numCols;
      
      seen.add(encodedPos);
      
      for(int[] direction: directions) {
        int r = row + direction[0];
        int c = col + direction[1];
        if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] == 'X') continue;
        encodedPos = encode(r, c);
        if(seen.contains(encodedPos)) continue;
        queue.add(encodedPos);
      }
    }
    
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(!seen.contains(encode(i, j)) && board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }
  
  private int encode(int row, int col) {
    return (numCols * row) + col;
  }
	
	// anything passed this is for dfs
  public void solve_DFS(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    
    for(int i = 0; i < m; i++) {
      dfs(board, i, 0);
      dfs(board, i, n-1);
    }
    
    for(int i = 0; i < n; i++) {
      dfs(board, 0, i);
      dfs(board, m-1, i);
    }
    
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        else if(board[i][j] == '.') {
          board[i][j] = 'O';
        }
      }
    }
  }
  
  private void dfs(char[][] board, int row, int col) {
    if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') return;
    
    board[row][col] = '.';
    
    for(int[] direction: directions) {
      dfs(board, row + direction[0], col + direction[1]);
    }
  }

}