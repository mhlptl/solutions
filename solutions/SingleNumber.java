package solutions;
import java.util.Set;
import java.util.HashSet;

/**
 * LEETCODE: Single Number (136) [EASY]
 * 
 * solution 1:
 * use set to keep track of numbers that are in the array
 * if we see a number we already have seen, remove it from the set
 * the only number that remains after the loop finishes is the answer
 * 
 * solution 2:
 * use bit manipulation
 * for each number we see, use the XOR function
 * the only number remaining should be the number that appears once
 * why? when we XOR the same two numbers we get 0
 * if we keep doing that, every pair will set the bits to 0
 * the only bits that will be set 1 will be the ones that correspond to the answer
 */
public class SingleNumber {

	public int solution1(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num: nums) {
				if(set.contains(num)) set.remove(num);
				else set.add(num);
		}
		
		for(Integer i: set) return i;
		return 0;
	}

	public int solution2(int[] nums) {
		int res = 0;
		
		for(int num: nums) {
			res = res ^ num;
		}
		return res;
	}
}