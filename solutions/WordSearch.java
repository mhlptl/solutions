package solutions;

/**
 * LEETCODE: Word Search (79) [MEDIUM]
 * 
 * backtracking algo
 * 
 * switch board[row][col] with temp value
 * after returning, switch value back to normal
 * the value of word.charAt(index) will have the correct
 * value because the algo would've failed 
 * if board[row][col] != word.charAt(index)
 * 
 * instead of switching the value,
 * using a set to keep track of locations visited could have worked
 */
public class WordSearch {
	  
  private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    
    if(word.length() > m * n) return false;
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(dfs(board, i, j, 0, word)) return true;
      }
    }
    
    return false;
    
  }
  
  private boolean dfs(char[][] board, int row, int col, int index, String word) {
    if(index >= word.length()) return true;
    if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || (index < word.length() && word.charAt(index) != board[row][col])) return false;
    
    board[row][col] = '0';
    
    for(int[] direction: directions) {
      int r = direction[0] + row;
      int c = direction[1] + col;
      if(dfs(board, r, c, index+1, word)) return true;
    }
    
    board[row][col] = word.charAt(index);
    return false;
  }
}
