package solutions;

/**
 * LEETCODE: Move Zeroes (283) [EASY]
 * 
 * use two pointers
 * one pointer to move only when we swap
 * one pointer to move on every iteration
 * swap when the moving pointer is not equal to zero
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 0;
		int n = nums.length;

		while(j < n) {
			if(nums[j] != 0) {
				swap(nums, i++, j);
			}
			j++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
