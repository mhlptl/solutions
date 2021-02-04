package solutions;

/**
 * LEETCODE: Factorial Trailing Zeroes (172) [EASY]
 * 
 * TODO: need writeup
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int numZeros = 0;
		
    while(n > 0) {
      n /=5 ;
      numZeros += n;
    }
    
    return numZeros;
  }
}
