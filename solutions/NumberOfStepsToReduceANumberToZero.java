package solutions;

/**
 * LEETCODE: Number of Steps to Reduce a Number to Zero (1342) [EASY]
 * 
 * simulate the steps and record the number of steps
 */
public class NumberOfStepsToReduceANumberToZero {
	public int numberOfSteps (int num) {
    int numSteps = 0;
    
    while(num != 0) {
      if(num % 2 == 0) num /= 2;
      else num -= 1;
      numSteps++;
    }
    
    return numSteps;
  }
}
