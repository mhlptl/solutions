package solutions;

/**
 * LEETCODE: Pow(x, n) (50) [MEDIUM]
 * 
 * solution 1 - brute force:
 * solve until we hit n = 0; takes O(n) time
 * 
 * solution 2 - recursive
 * base case is when the exponent is 0 (equal to 1)
 * keep dividing by 2
 * we know that we can either have a exponent which is odd or even
 * if it is even, we can multiply the result by itself
 * else we can multiply the result by itself and by the base
 * 
 * if n == even -> x^n = x^(n/2) * x^(n/2)
 * if n == odd -> x^n = x^(n/2) * x^(n/2) * x
 * 
 * x = 2, n = 10
 * 
 * x = 2, n = 10, half = (32*32) = 1024
 * x = 2, n = 5, half = (4*4)*2 = 32 
 * x = 2, n = 2, half = 2*2 = 4
 * x = 2, n = 1, half = (1*1)*2 = 2
 * x = 2, n = 0, half = 1 (base case)
 * 
 */
public class PowXN {
	public double myPow_solution1(double x, int n) {
    if(x == 0) return 0;
    if(x == 1) return 1;
    if(n < 0) {
      x = 1/x;
      n = -n;
    }
    
    double result = 1.0;
    
    while(n != 0) {
      result = result * x;
      n--;
    }
    
    return result;
  }

	public double myPow_solution2(double x, int n) {
    if(x == 0) return 0;
    if(x == 1) return 1;
    if(n < 0) {
      x = 1/x;
      n = -n;
    }
    
    return getPow(x, n);
  }
  
  private double getPow(double x, int n) {
    if(n == 0) return 1.0;
    double half = getPow(x, n/2);
    if(n % 2 == 0) {
      return half * half;
    }
    else {
      return half * half * x;
    }
  }
}
