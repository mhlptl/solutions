package solutions;

/**
 * LEETCODE: Reverse Bits (190) [EASY]
 * 
 * shift result to the left by 1 bit
 * check if n shifted to the right by i has the bit 1
 * if it has the 1 bit, add the one bit to result or add the 0 bit  
 */
public class ReverseBits {
	public int reverseBits(int n) {
    int result = 0;
    for(int i = 0; i < 32; i++) {
      result = result << 1;
      result = result | ((n >> i) & 1);
    }
    
    return result;
  }
}
