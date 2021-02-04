package solutions;

/**
 * LEETCODE: Plus One (66) [EASY]
 * 
 * if the element is equal to 9 set it to 0
 * if the element is not equal to 9, increment by 1 and return the array
 * why return? if the element is not equal to 9, we are done adding 1 because there is no carry (9+1 = 10; 8+1=9)
 * we only need to change the array size if all the elements are equal to 9
 * when we create a new array, all the elements are equal to zero
 * so we just have to set the first element to 1
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
    if(digits == null || digits.length == 0) return digits;
     
    int n = digits.length-1;

    while(n >= 0) {
      if(digits[n] == 9) {
        digits[n] = 0;
      }
      else {
        digits[n]++;
        return digits;
      }
      n--;
    }
    
    digits = new int[digits.length+1];
    digits[0] = 1;
    
    return digits;
  }
}
