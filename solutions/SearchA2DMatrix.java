package solutions;

/**
 * LEETCODE: Search a 2D Matrix (74) [MEDIUM]
 * 
 * TODO: need writeup
 */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
    int row = findRow(matrix, 0, matrix.length-1, target);
    return binarySearch(matrix[row], 0, matrix[row].length-1, target);
  }
  
  private boolean binarySearch(int[] arr, int lo, int hi, int target) {
    while(lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if(arr[mid] == target) return true;
      else if(arr[mid] < target) lo = mid+1;
      else if(arr[mid] > target) hi = mid-1;
    }
    
    return false;
  }
  
  private int findRow(int[][] matrix, int lo, int hi, int target) {
    while(lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int n = matrix[mid].length;
      if(matrix[mid][0] <= target && matrix[mid][n-1] >= target) return mid;
      if(matrix[mid][0] > target) hi = mid-1;
      else if(matrix[mid][n-1] < target) lo = mid+1;
    }
    return lo;
  }
}
