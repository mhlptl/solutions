package solutions;

/**
 * LEETCODE: Search a 2D Matrix II (240) [MEDIUM]
 * 
 * TODO: need writeup
 */
public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length-1;
    int n = 0;
    
    while(m >= 0 && n < matrix[0].length) {
      if(matrix[m][n] == target) return true;
      else if(matrix[m][n] < target) n++;
      else if(matrix[m][n] > target) m--;
    }
    
    return false;
  }
}
