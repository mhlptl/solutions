package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE: Partition Labels (763) [MEDIUM]
 * 
 * store rightmost index for each letter
 * as we iterate the string
 * make rightmost = max(current rightmost, rightmost index of current char)
 * if rightmost == i -> add length to list (we found where to partition)
 * 
 * other solution: create intervals from (leftmost index, rightmost index) for each character
 * and merge overlapping
 */
public class PartitionLabels {
  public List<Integer> partitionLabels(String S) {
    List<Integer> result = new ArrayList<>();
    
    int[] rightMostIndex = new int[26];
    
    for(int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      rightMostIndex[ch - 'a'] = i;
    }
    
    int i = 0;
    int rightMost = -1;
    
    for(int j = 0; j < S.length(); j++) {
      rightMost = Math.max(rightMost, rightMostIndex[S.charAt(j) - 'a']);
      if(j == rightMost) {
        result.add(j - i + 1);
        i = j+1;
      }
    }
    
    return result;
  }
	
}