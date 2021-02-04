package solutions;

/**
 * LEETCODE: Valid Palindrome (125) [EASY]
 * 
 * use two pointers 
 * one starting from the front
 * one starting from the back
 * if the character is not a letter or digit, loop until you find a character
 * if the character is a letter or digit, check if they are equal
 * if they are not equal, it is not a palindrome
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
    if(s == null || s.length() < 2) return true;
    
    int i = 0;
    int j = s.length()-1;
    
    while(i < j) {
      char front = s.charAt(i);
      char back = s.charAt(j);
      
      while(i < j && !Character.isLetterOrDigit(front)) {
        front = s.charAt(++i);
      }
      
      while(i < j && !Character.isLetterOrDigit(back)) {
        back = s.charAt(--j);
      }
      
      if(Character.toLowerCase(front) != Character.toLowerCase(back)) return false;
      i++;
      j--;
    }
    return true;
  }
}
