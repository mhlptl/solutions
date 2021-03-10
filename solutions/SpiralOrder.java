package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE: Spiral Order (54) [MEDIUM]
 * 
 * TODO: writeup
 */
public class SpiralOrder {
	public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    
    int rowStart = 0;
    int rowEnd = matrix.length-1;
    int colStart = 0;
    int colEnd = matrix[0].length-1;
    int m = matrix.length;
    int n = matrix[0].length;
    
    while(result.size() != m * n) {
      // left to right
      for(int i = colStart; i <= colEnd; i++) {
        result.add(matrix[rowStart][i]);
      }
      rowStart++;
      
      // top to bottom
      for(int i = rowStart; i <= rowEnd; i++) {
        result.add(matrix[i][colEnd]);
      }
      colEnd--;
      
      // right to left;
      if(rowStart <= rowEnd) {
        for(int i = colEnd; i >= colStart; i--) {
          result.add(matrix[rowEnd][i]);
        }
      }
      rowEnd--;
      
      // bottom to top
      if(colStart <= colEnd) {
        for(int i = rowEnd; i >= rowStart; i--) {
          result.add(matrix[i][colStart]);
        }        
      }
      colStart++;
    }
    
    return result;
  }
}
