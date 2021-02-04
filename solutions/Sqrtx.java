package solutions;

/**
 * LEETCODE: Sqrt(x) (69) [EASY]
 * 
 * use binary search to find the sqrt of x
 * we can have the starting boundaries to be [0, x/2]
 * use long to calculate mid to protect from overflow
 * if found, return mid else return hi
 */
public class Sqrtx {
	public int mySqrt(int x) {
    if(x == 1) return 1;
    return binarySearch(x, 0, x/2);
  }
  
  private int binarySearch(int x, int lo, int hi) {
    while(lo <= hi) {
      long mid = lo + (hi - lo) / 2;
      
      if((mid * mid) == x) return (int)mid;
      if((mid * mid) > x) {
        hi = (int)mid-1;
      }
      else {
        lo = (int)mid+1;
      }
    }
    
    return hi;
  }
}
