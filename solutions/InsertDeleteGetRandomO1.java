package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * LEETCODE: Insert Delete GetRandom O(1) (380) [MEDIUM]
 * 
 * to get O(1) deletion 
 * 1. use hashmap to keep track of indexes for each value
 * 2. swap last item and item to be deleted that way the last index is to be deleted
 * 
 * to get O(1) insertion
 * 1. add to end of list
 * 
 * to get O(1) getRandom
 * 1. using an ArrayList we can index any item in the list
 */
public class InsertDeleteGetRandomO1 {

  Map<Integer, Integer> map;
  List<Integer> list;
  
  /** Initialize your data structure here. */
  public InsertDeleteGetRandomO1(){
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(map.containsKey(val)) {
      return false;
    }
    map.put(val, list.size());
    list.add(list.size(), val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(!map.containsKey(val)) {
      return false;
    }
    int index = map.get(val);
    int lastItem = list.get(list.size()-1);
    list.set(list.size()-1, val);
    list.set(index, lastItem);
    map.put(lastItem, index);
    map.remove(val);
    list.remove(list.size()-1);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    Random rand = new Random();
    int index = rand.nextInt(list.size());
    return list.get(index);
  }
}