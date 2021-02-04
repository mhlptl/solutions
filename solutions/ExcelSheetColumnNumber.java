package solutions;

/**
 * LEETCODE: Excel Sheet Column Number (171) [EASY]
 * 
 * TODO: need writeup
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
    int result = 0;
    
    for(char ch: s.toCharArray()) {
      result = (result * 26) + (ch-'A'+1);
    }
    return result;
  }
}
