package solutions;

/**
 * LEETCODE: Game of Life (289) [MEDIUM]
 * 
 * solution 1:
 * use extra space to solve problem 
 * then copy over the results 
 * using copyArray function
 * 
 * solution 2:
 * use identifiers to keep track of changed cells
 * -1 -> any live cell becoming dead
 * -2 -> any dead cell becoming alive
 * change identifiers to alive (1) or dead (0) after loop finishes
 */
public class GameOfLife {

	int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

  public void gameOfLife_solution1(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[][] result = new int[m][n];
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int liveNeighbors = checkNeighbors(board, i, j);
        if(board[i][j] == 1) {
          if(liveNeighbors < 2 || liveNeighbors > 3) result[i][j] = 0;
          else result[i][j] = 1;
        }
        else if(board[i][j] == 0 && liveNeighbors == 3) result[i][j] = 1;
      }
    }
    copyArray(result, board);
  }
  
	// used for solution 1
  private void copyArray(int[][] src, int[][] dest) {
    for(int i = 0; i < src.length; i++) {
      for(int j = 0; j < src[0].length; j++) {
        dest[i][j] = src[i][j];
      }
    }
  }

	// solution 2
	public void gameOfLife_solution2(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    
    final int turnDead = -1;
    final int turnAlive = -2;
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int liveNeighbors = checkNeighbors(board, i, j);
        if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) board[i][j] = turnDead;
        else if(board[i][j] == 0 && liveNeighbors == 3) board[i][j] = turnAlive;
      }
    }
    
    convertResults(board);
  }

	// used for solution 2
	private void convertResults(int[][] board) {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(board[i][j] == -1) board[i][j] = 0;
        else if(board[i][j] == -2) board[i][j] = 1;
      }
    }
  }

	// used for both solutions
	private int checkNeighbors(int[][] board, int row, int col) {
		int liveNeighbors = 0;
		for(int[] direction: directions) {
			int neighborRow = row + direction[0];
			int neighborCol = col + direction[1];
			if(neighborRow < 0 || neighborRow >= board.length || neighborCol < 0 || neighborCol >= board[0].length) continue;
			if(board[neighborRow][neighborCol] == 1) liveNeighbors++;
		}
		return liveNeighbors;
	}
}