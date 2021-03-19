package solutions;

import java.util.Random;

/**
 * LEETCODE: Shuffle an Array (384) [MEDIUM]
 * 
 * use Fisher-Yates Shuffling Algorithm
 */
public class ShuffleAnArray {

  int[] duplicate;
  int[] original;

  public ShuffleAnArray(int[] nums) {
    this.duplicate = nums;
    this.original = this.duplicate.clone();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    duplicate = original.clone();
    return original;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int n = duplicate.length;
    for(int i = 0; i < n; i++) {
      int j = getInt(i, n);
      int temp = duplicate[i];
      duplicate[i] = duplicate[j];
      duplicate[j] = temp;
    }
    return duplicate;
  }
  
  private int getInt(int start, int end) {
    Random rand = new Random();
    return (rand.nextInt(end - start) + start);
  }
	
}