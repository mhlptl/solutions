package solutions;

/**
 * LEETCODE: Divide Two Integers (29) [MEDIUM]
 * 
 * solution 1 - brute force:
 * make numbers negative that way we can have the biggest range of numbers (2^31)
 * 
 * solution 2 - doubling
 * make the numbers negative that way we can have the biggest range of numbers (2^31)
 * keep doubling the divisor
 * if the divisor doubled once more is > dividend, stop
 * add the powerOfTwo to the result
 * keep doing this while the divisor >= dividend
 */
public class DivideTwoIntegers {
	public int divide_solution1(int dividend, int divisor) {
    if(dividend == 0) return 0;
    if(dividend == divisor) return 1;
    if(dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    int result = 0;
    boolean isNeg = false;
    if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
      isNeg = true;
    }
    
    if(dividend > 0) dividend = -dividend;
    if(divisor > 0) divisor = -divisor;
    
    while(dividend - divisor <= 0) {
      dividend -= divisor;
      result++;
    }
    
    return isNeg ? -result : result;
  }

	public int divide_solution2(int dividend, int divisor) {
    if(dividend == 0) return 0;
    if(dividend == divisor) return 1;
    if(dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    int result = 0;
    
    int negatives = 2;
    
    if(dividend > 0) {
      dividend = -dividend;
      negatives--;
    }
    if(divisor > 0) {
      divisor = -divisor;
      negatives--;
    }
    
    while(divisor >= dividend) {
      int powerOfTwo = -1;
      int value = divisor;

      while(value >= Integer.MIN_VALUE/2 && value + value >= dividend) {
        value += value;
        powerOfTwo += powerOfTwo;
      }

      result += powerOfTwo;

      dividend -= value;
    }
    
    if(negatives != 1) {
      return -result;
    }
    return result;
  }
}
