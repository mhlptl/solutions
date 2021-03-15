package solutions;

import java.util.Comparator;
import java.util.Arrays;

/**
 * LEETCODE: Largest Number (179) [MEDIUM]
 * 
 * we want to sort by each digit of the numbers
 * to sort, convert list to string and use comparator
 * compare the concatenation of s1+s2 and s2+s1
 * if s1+s2 > s2+s1 return -1 because s1 will produce a larger string than s2
 * else return 1 because s2 will produce a larget string s1
 * if after sorting, the first element is 0, return "0"
 * else concat all elements and return
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
    Comparator<String> myComparator = new Comparator<String>(){
      @Override
      public int compare(String s1, String s2) {
        String order1 = s1 + s2;
        String order2 = s2 + s1;
        
        return order2.compareTo(order1);
      }
    };
      
    String[] strs = new String[nums.length];
    for(int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    
    Arrays.sort(strs, myComparator);
    
    if(strs[0].equals("0")) return "0";
    
    StringBuilder sb = new StringBuilder();
    
    for(String s: strs) {
      sb.append(s);
    }
    
    return sb.toString();
  }
}
