package solutions;

import java.util.Arrays;
import java.util.HashSet;

/**
 * LEETCODE: Short Encoding of Words (820) [MEDIUM]
 * 
 * TODO: writeup
 */
public class ShortEncodingOfWords {
	public int minimumLengthEncoding(String[] words) {
    HashSet<String> set = new HashSet<>(Arrays.asList(words));
    
    for(String word: words) {
      for(int i = 1; i < word.length(); i++) {
        set.remove(word.substring(i));
      }
    }
    
    int result = 0;
    
    for(String word: set) {
      result += word.length() + 1;
    }
    
    return result;
  }
}
