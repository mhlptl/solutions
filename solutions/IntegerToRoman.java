package solutions;

/**
 * LEETCODE: Integer to Roman (12) [MEDIUM]
 * 
 * start with the largest numeral
 * if its value is less than or equal to the current number
 * append it to the string, and subtract that value from the current num
 * else decrement the index
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
    int[] numbers = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    
    int index = romans.length-1;
    StringBuilder sb = new StringBuilder();
    
    while(num > 0 && index >= 0) {
      int val = numbers[index];
      if(num >= val) {
        sb.append(romans[index]);
        num -= val;
      }
      else {
        index--;
      }
    }
    
    return sb.toString();
  }
}
