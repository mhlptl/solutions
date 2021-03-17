package solutions;

/**
 * LEETCODE: Jump Game (55) [MEDIUM]
 * 
 * solution 1: brute force backtracking -> Time Exceeded
 * solution 2: backtracking w/ memoization (top down)
 * solution 3: iterative w/ memoization (bottom up)
 * solution 4: greedy
 * 
 * we want to see if we could jump from index 0 to n
 * 
 * memoization table: 0 = unknown; -1 = bad; 1 = good
 */
public class JumpGame {

	// backtracking
	public boolean canJump_solution1(int[] nums) {
    return backtrack(nums, 0);
  }
  
  private boolean backtrack(int[] nums, int index) {
    if(index == nums.length-1) {
      return true;
    }
    
    int furthestJump = Math.min(nums.length-1, nums[index] + index);
    
    for(int i = furthestJump; i > index; i--) {
      if(backtrack(nums, i)) {
        return true;
      }
    }
    
    return false;
  }

	// top down (backtracking w/ memoization)
	public boolean canJump__solution2(int[] nums) {
    int[] memo = new int[nums.length];
    memo[nums.length-1] = 1;
    return backtrack(0, nums, memo);
  }
  
  private boolean backtrack(int index, int[] nums, int[] memo) {
    if(memo[index] != 0) {
      return memo[index] == 1;
    }
    
    int furthestJump = Math.min(nums.length-1, nums[index] + index);
    
    for(int i = furthestJump; i > index; i--) {
      if(backtrack(i, nums, memo)) {
        memo[index] = 1;
        return true;
      }
    }
    
    memo[index] = -1;
    return false;
  }

	// bottom up
	public boolean canJump_solution3(int[] nums) {
    int[] memo = new int[nums.length];
    memo[nums.length-1] = 1;
    
    for(int i = nums.length-2; i >= 0; i--) {
      int furthestJump = Math.min(nums.length-1, nums[i] + i);
      for(int j = i+1; j <= furthestJump; j++) {
        if(memo[j] == 1) {
          memo[i] = 1;
          break;
        }
      }
    }
    
    return memo[0] == 1;
  }

	// greedy
	public boolean canJump_solution4(int[] nums) {
    int lastPos = nums.length-1;
    
    for(int i = nums.length-1; i >= 0; i--) {
      if(nums[i] + i >= lastPos) {
        lastPos = i;
      }
    }
    
    return lastPos == 0;
  }
}
