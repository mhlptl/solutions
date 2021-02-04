package solutions;

/**
 * LEETCODE: Reverse String (344) [EASY]
 * 
 * to reverse the string use two pointers
 * start one from the front and the other from the end
 * meet in the middle while swapping the values from both pointers
 */
public class ReverseString {
	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		
		while(i < j) {
				char temp = s[i];
				s[i] = s[j];
				s[j] = temp;
				i++;
				j--;
		}
	}
}