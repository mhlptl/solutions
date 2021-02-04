package solutions;

/**
 * LEETCODE: Valid Anagram (242) [EASY]
 * 
 * use frequency table (think of a hashmap) to store frequency of characters
 * for each letter in string s, increment frequency of that letter
 * for each letter in string t, decrement frequency of that letter
 * if any values in the frequency table is not equal to 0, string t is not an anagram of string s
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;
    
    int[] frequency = new int[26];
    
    for(int i = 0; i < s.length(); i++) {
      frequency[s.charAt(i) - 'a']++;
      frequency[t.charAt(i) - 'a']--;
    }
    
    for(int freq: frequency) {
      if(freq != 0) return false;
    }
    
    return true;
  }
}