package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE: Reordered Power of Two (869) [MEDIUM]
 * 
 * store power of twos (only check the ones that has same # of digis as N)
 * if the frequency of the current digit < 0 return false (not a match)
 */
public class ReorderedPowerOf2 {
	public boolean reorderedPowerOf2(int N) {
    List<String> powerOfTwos = fillList();
    int[] digits = getDigits(N);
    int size = digits[10];
    for(String power: powerOfTwos) {
      if(power.length() == size) {
        if(check(power, digits.clone())) return true;
      }
    }
    return false;
  }
  
  private List<String> fillList() {
    List<String> powerOfTwos = new ArrayList<>();
    int num = 1;
    powerOfTwos.add("1");
    for(int i = 1; i < 31; i++) {
      num = num * 2;
      powerOfTwos.add(String.valueOf(num));
    }
    return powerOfTwos;
  }
  
  private int[] getDigits(int N) {
    int[] freq = new int[11];
    int size = 0;
    while(N > 0) {
      int rem = N % 10;
      freq[rem]++;
      N /= 10;
      size++;
    }
    freq[10] = size;
    return freq;
  }
  
  private boolean check(String S, int[] freq) {
    for(Character ch: S.toCharArray()) {
      freq[ch - '0']--;
      if(freq[ch - '0'] < 0) return false;
    }
    return true;
  }
}
