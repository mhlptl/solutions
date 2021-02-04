package solutions;

/**
 * LEETCODE: Power of Three (326) [Easy]
 * 
 * if n mod 3 is zero, keep dividing by 3
 * by the end of the loop, if n == 1, we know it was a power of three
 * else we know it was not 
 * 18/3 -> 6/3 -> 2 = Not Power of Three
 * 27/3 -> 9/3 -> 3 -> 1 = Power of Three
 */
public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
    if(n < 1) return false;

    while(n % 3 == 0) {
      n /= 3;
    }
    
    return n == 1;
  }
}
