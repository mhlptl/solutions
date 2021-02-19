package solutions;

/**
 * LEETCODE: Set Matrix Zeroes (73) [MEDIUM]
 * 
 * o(1) space
 * use first col and first row to store whether row or col has a zero value
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    
    boolean rowZero = false;
    boolean colZero = false;
    
    for(int i = 0; i < m; i++) {
      if(matrix[i][0] == 0) {
        colZero = true;
        break;
      }
    }
    
    for(int i = 0; i < n; i++) {
      if(matrix[0][i] == 0) {
        rowZero = true;
        break;
      }
    }
    
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(matrix[i][j] != 0) continue;
        matrix[i][0] = 0;
        matrix[0][j] = 0;
      }
    }
   
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0; 
        }
      }
    }
    
    if(rowZero) {
      for(int i = 0; i < n; i++) {
        matrix[0][i] = 0;
      }
    }
    if(colZero) {
      for(int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
    
  }
}
