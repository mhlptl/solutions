package solutions;

/**
 * LEETCODE: Rotate Image (48) [MEDIUM]
 * 
 * group by 4 and then rotate those
 * 
 * TODO: transpose and then rotate
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
    int n = matrix.length;
    for(int row = 0; row < n / 2; row++) {
      for(int col = row; col < n - row - 1; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[n-col-1][row];
        matrix[n-col-1][row] = matrix[n-row-1][n-col-1];
        matrix[n-row-1][n-col-1] = matrix[col][n-row-1];
        matrix[col][n-row-1] = temp;
      }
    }
  }
}