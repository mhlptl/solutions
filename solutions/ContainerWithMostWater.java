package solutions;

/**
 * LEETCODE: Container with Most Water (11) [MEDIUM]
 * 
 * use two pointers (one at beginning and one at end)
 * get max area we can produce at that point
 * increment/decrement the iterator with the smaller value
 * why? we want to maximize the area, if we move the smaller of the two,
 * we can hope to find a larger value
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
    int i = 0;
    int j = height.length-1;
    int maxArea = 0;
    
    while(i < j) {
      maxArea = Math.max(Math.min(height[i], height[j]) * (j-i), maxArea);
      if(height[i] < height[j]) i++;
      else j--;
    }
    
    return maxArea;
  }
}
