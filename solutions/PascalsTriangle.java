package solutions;
import java.util.List;
import java.util.ArrayList;

/**
 * LEETCODE: Pascal's Triangle (118) [EASY]
 * 
 * use the previous list to compute the current list
 * can also cut the list in half so we only have to compute half as much
 * because pascal's triangle is symmetrical down the middle
 * just copy over the values to the end of the list by starting at the (currRow-2)/2 to 0
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
    if(numRows <= 0) return new ArrayList<>();
    
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<Integer>());
    result.get(0).add(1);
    
    for(int currRow = 2; currRow <= numRows; currRow++) {
      List<Integer> prev = result.get(currRow-2);
      List<Integer> inner = new ArrayList<Integer>();
      
      inner.add(1);
      for(int i = 1; i < (currRow+1)/2; i++) {
        inner.add(prev.get(i-1) + prev.get(i));
      }
      
      for(int i = (currRow-2)/2; i >= 0; i--) {
        inner.add(inner.get(i));
      }
      result.add(inner);
    }
    return result;
  }
}
