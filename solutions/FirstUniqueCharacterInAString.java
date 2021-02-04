package solutions;

/**
 * LEETCODE: First Unique Character in a String (387) [EASY]
 * 
 * use a frequency table (can also use hashtable) to store the frequency of characters from string s
 * for each character in string s, increment its value in the frequency table
 * on the second pass of string s, the first character with the frequency of 1 is the first unique character
 */
public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
    int[] frequency = new int[26];

    for(char ch: s.toCharArray()) {
      frequency[ch-'a']++;
    }
    
    for(int i = 0; i < s.length(); i++) {
      if(frequency[s.charAt(i)-'a'] == 1) return i;
    }
    return -1;
  }
}
