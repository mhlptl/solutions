package solutions;
import java.util.Set;
import java.util.HashSet;

/**
 * LEETCODE: Happy Number (202) [EASY]
 * 
 * use hashset to keep track of seen values
 * why? so we can return if there is a cycle
 * keep setting n to the sum of the squares of each digit
 */
public class HappyNumber {
	public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<Integer>();
    set.add(n);
    while(n != 1) {
      n = getSum(n);
      if(set.contains(n)) return false;
      set.add(n);
    }
    return true;
  }
  
  private int getSum(int n) {
    int sum = 0;
    
    while(n != 0) {
      int digit = n % 10;
      sum += (digit * digit);
      n /= 10;
    }
    
    return sum;
  }
}