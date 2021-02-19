package solutions;

/**
 * LEETCODE: Arithmetic Slices (413) [MEDIUM]
 * 
 * found pattern on how to compute the number of windows of size 3 or more
 * add the number of windows to result if the window size is equal to 3 or more
 * only add if the previous difference does not equal the current difference OR
 * if we are at the end of the array
 */
public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A) {
    if(A.length < 3) return 0;
    int result = 0;
    int n = 2;
    int difference = A[1] - A[0];
    for(int i = 2; i < A.length; i++) {
      if(A[i] - A[i-1] == difference) {
        n++;
      } 
      if(A[i] - A[i-1] != difference || i == A.length-1) {
        difference = A[i] - A[i-1];
        if(n > 2) {
          result += ((n * (n-1)) / 2 - (n-1));
          n = 2;
        }
      }
    }
    
    return result;
  }
}
