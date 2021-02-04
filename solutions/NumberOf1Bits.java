package solutions;

/**
 * LEETCODE: Number of 1 Bits (191) [EASY]
 * 
 * using bit manipulation we can get the number of 1 bits
 * because we are using 32 bit numbers we can loop from 0..31
 * if n & 1 is equal to 1 increment weight
 * shift n to the right by 1
 */
public class NumberOf1Bits {
	public int hammingWeight(int n) {
		int weight = 0;
		for(int i = 0; i < 32; i++) {
			if((n & 1) == 1) weight++;
			n = n >> 1;
		}  
		return weight;
	}
}
