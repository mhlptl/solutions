package solutions;
import java.util.Arrays;
import java.util.Comparator;

/**
 * LEETCODE: Meeting Rooms (252) [EASY]
 * 
 * sort by start time (least to greatest)
 * sort by end time, if the start times are equal (greatest to least)
 * then loop through the intervals
 * if the end time is greater than the next elements start time (overlap), return false
 */
public class MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
    Comparator<int[]> myComp = new Comparator<>(){
      @Override
      public int compare(int[] m1, int[] m2) {
        if(m1[0] < m2[0]) return -1;
        if(m1[0] > m2[0]) return 1;
        return Integer.compare(m1[1], m2[1]);
      }
    };
    
    Arrays.sort(intervals, myComp);
    
    for(int i = 1; i < intervals.length; i++) {
      int[] before = intervals[i-1];
      int[] curr = intervals[i];
      if(before[1] > curr[0]) return false;
    }
    
    return true;
  }
}
