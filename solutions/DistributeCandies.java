package solutions;
import java.util.HashSet;
import java.util.Set;

/**
 * LEETCODE: Distribute Candies (575) [EASY]
 * 
 * TODO: need writeup
 */
public class DistributeCandies {
	public int distributeCandies(int[] candyType) {
    Set<Integer> set = new HashSet<>();
    
    for(int candy: candyType) {
      set.add(candy);
    }
    
    int n = candyType.length;
    
    return Math.min(n / 2, set.size());
  }
}
