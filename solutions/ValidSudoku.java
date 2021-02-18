package solutions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LEETCODE: Valid Sudoku (36) [MEDIUM]
 * 
 * have set for every row, col, and subBox
 * iterate through every element in the board
 * if the element is a number
 * check if it is in any set for that row, col, and subBox
 * if not, add it to the corresponding sets
 * else return false
 * if we run through a valid board, return true
 * 
 * to get the current subBox
 * (i / 3) * 3 + (j / 3)
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
    List<Set<Integer>> rows = new ArrayList<>();
    List<Set<Integer>> cols = new ArrayList<>();
    List<Set<Integer>> subBox = new ArrayList<>();
    
    for(int i = 0; i < 9; i++) {
      rows.add(new HashSet<>());
      cols.add(new HashSet<>());
      subBox.add(new HashSet<>());
    }
    
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        int index = (i / 3) * 3 + (j / 3);
        if(board[i][j] >= '1' && board[i][j] <= '9') {
          int val = (int)board[i][j];
          if(rows.get(i).contains(val) || cols.get(j).contains(val) || subBox.get(index).contains(val)) return false;
          rows.get(i).add(val);
          subBox.get(index).add(val);
          cols.get(j).add(val);
        }
      }
    }
    
    return true;
  }
}
