package solutions;

/**
 * LEETCODE: Set Mismatch (645) [EASY]
 * 
 * TODO: need writeup
 */
public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
    int[] freq = new int[nums.length];
    
    for(int num: nums){
      freq[num-1]++;
    }
    
    
    int[] result = new int[2];
    
    for(int i = 0; i < freq.length; i++) {
      if(freq[i] == 0) {
        result[1] = i+1;
      }
      else if(freq[i] > 1) {
        result[0] = i+1;
      }
      if(result[0] != 0 && result[1] != 0) break;
    }
    
    return result;
  }
}
