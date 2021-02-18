package solutions;
import java.util.Arrays;
import java.util.Comparator;

/**
 * LEETCODE: Merge Intervals (56) [MEDIUM]
 * 
 * sort by start times (smaller number comes first)
 * if start times are equal, sort by end times (larger number comes first)
 * merge intervals (if previous interval endtime is less than equal to current startime merge)
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
    if(intervals == null || intervals.length <= 1) return intervals;
    
    Comparator<int[]> myComp = new Comparator<>(){
      @Override
      public int compare(int[] int1, int[] int2) {
        if(Integer.compare(int1[0], int2[0]) == 0) {
          return int2[1] - int1[1];
        }
        return int1[0] - int2[0];
      }
    };
    Arrays.sort(intervals, myComp);
    
    int i = 0;
    int j = 1;
    int n = intervals.length;
    
    while(j < n) {
      int[] prev = intervals[i];
      int[] curr = intervals[j];
      
      if(curr[0] <= prev[1]) {
        prev[1] = Math.max(prev[1], curr[1]);
      }
      else {
        prev = intervals[++i];
        prev[0] = curr[0];
        prev[1] = curr[1];
      }
      j++;
    }
    
    return Arrays.copyOf(intervals, i+1);
  }
}
