package solutions;
import java.util.Iterator;

/**
 * LEETCODE: Peeking Iterator (284) [MEDIUM]
 * 
 * TODO: need writeup
 */
public class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
  Integer peekedValue;
  
	public PeekingIterator(Iterator<Integer> iterator) {
	  // initialize any member here.
	  this.iterator = iterator;
    this.peekedValue = null;

	}
	
  // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
    if(peekedValue == null) {
      if(iterator.hasNext()) {
        peekedValue = iterator.next();
      }
    }
    return peekedValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
    if(peekedValue != null) {
      Integer toReturn = peekedValue;
      peekedValue = null;
      return toReturn;
    }
    if(iterator.hasNext()) {
      return iterator.next();
    }
    return null;
	}
	
	@Override
	public boolean hasNext() {
    return iterator.hasNext() || peekedValue != null;
	}
}
