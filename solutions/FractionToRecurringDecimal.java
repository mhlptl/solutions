package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE: Fraction to Recurring Decimal (166) [MEDIUM]
 * 
 * convert to long because of overflow
 * do long divison
 * use map to keep track of remainder and the location of the start of the remainder in the string
 * if we seen the remainder once again (we know its repeating)
 * get the location from the map, place an opening parentheses at the position
 * then place a closing parentheses at the end of the string
 * 
 */
public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder sb = new StringBuilder();
    
    if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
      sb.append('-');
    }
    
    long dividend = Math.abs(Long.valueOf(numerator));
    long divisor = Math.abs(Long.valueOf(denominator));
    
    sb.append(dividend / divisor);
    
    long remainder = dividend % divisor;
    
    if(remainder == 0) {
      return sb.toString();
    }
    
    sb.append('.');
    
    Map<Long, Integer> map = new HashMap<>();
    
    while(remainder != 0) {
      if(map.containsKey(remainder)) {
        sb.insert(map.get(remainder), "(");
        sb.append(')');
        break;
      }
      map.put(remainder, sb.length());
      remainder *= 10;
      sb.append(remainder / divisor);
      remainder = remainder % divisor;
    }
    
    return sb.toString();
  }
}
