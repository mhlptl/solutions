package solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utils.NestedInteger;

/**
 * LEETCODE: Flatten Nested List Iterator (341) [MEDIUM]
 * 
 * use dfs to flatten list
 */
public class FlattenNestedListIterator {
	public class NestedIterator implements Iterator<Integer> {

		private List<Integer> result = new ArrayList<>();
		private int index;
		
		public NestedIterator(List<NestedInteger> nestedList) {
			dfs(nestedList, 0);
		}
	
		@Override
		public Integer next() {
			if(index < result.size()) return result.get(index++);
			return -1;
		}
	
		@Override
		public boolean hasNext() {
			if(index < result.size()) return true;
			return false;
		}
		
		private void dfs(List<NestedInteger> nestedList, int index) {
			if(index >= nestedList.size()) return;
			
			NestedInteger nestedInteger = nestedList.get(index);
			
			if(!nestedInteger.isInteger()) {
				dfs(nestedInteger.getList(), 0);
			}
			else {
				result.add(nestedInteger.getInteger());
			}
			dfs(nestedList, index+1);
		}
	
	}
}
