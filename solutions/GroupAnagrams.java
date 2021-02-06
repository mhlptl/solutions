package solutions;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * LEETCODE: Group Anagrams (49) [MEDIUM]
 * 
 * solution 1: time complexity (S * NlogN)
 * have key to be the sorted string (anagrams will have the same sorted string)
 * 
 * solution 2: time complexity (S * N)
 * have key be the frequency list of the string; takes O(N) time to create
 * use symbols in between to remove false positives
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams_solution1(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    
    for(String str: strs) {
      char[] tempArr = str.toCharArray();
      Arrays.sort(tempArr);
      String sorted = String.valueOf(tempArr);
      if(!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(str);
    }
    
    return new ArrayList<>(map.values());
  }

	public List<List<String>> groupAnagrams_solution2(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    int[] frequency = new int[26];
    for(String str: strs) {
      String key = getFrequencyString(str);
      if(!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }
    
    return new ArrayList<>(map.values());
  }
  
  private String getFrequencyString(String str) {
    int[] freq = new int[26];
    
    for(Character ch: str.toCharArray()) {
      freq[ch - 'a']++;
    }
    
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < freq.length; i++) {
      sb.append('#');
      sb.append(freq[i]);
    }
    return sb.toString();
  }
}