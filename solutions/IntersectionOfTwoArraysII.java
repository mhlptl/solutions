package solutions;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * LEETCODE: Intersection of Two Arrays II (350) [EASY]
 * 
 * store frequency of numbers from the smaller array in hashmap
 * iterate larger array, and for each number that is in the hashmap,
 * add it to result list as long as the frequency is above 0
 * decrement frequency for the number that we have added to the result list 
 */
public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
    if(nums1.length > nums2.length) {
      return search(nums1, storeFreq(nums2));
    }
    return search(nums2, storeFreq(nums1));
  }
  
  private Map<Integer, Integer> storeFreq(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for(int num: nums) {
      int freq = map.getOrDefault(num, 0);
      map.put(num, freq+1);
    }
    
    return map;
  }
  
  private int[] search(int[] nums, Map<Integer, Integer> map) {
    List<Integer> result = new ArrayList<Integer>();
    
    for(int num: nums) {
      int freq = map.getOrDefault(num, 0);
      if(freq > 0) {
        map.put(num, freq-1);
        result.add(num);
      }
    }
    
    return toArray(result);
  }
  
  private int[] toArray(List<Integer> list) {
    int[] result = new int[list.size()];
    
    for(int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    
    return result;
  }
}
