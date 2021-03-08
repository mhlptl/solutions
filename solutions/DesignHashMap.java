package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE: Design HashMap (706) [EASY]
 * 
 * create a class to have key-pair values
 * create another class to be a list of key-pair values
 * in the MyHashMap class have a list of the list of key-pair values
 */
public class DesignHashMap {
	class MyHashMap {

		List<Bucket> map;
		int numBuckets = 10;
		
		/** Initialize your data structure here. */
		public MyHashMap() {
			map = new ArrayList<>();
			for(int i = 0; i < numBuckets; i++) {
				map.add(new Bucket());
			}
		}
	
		/** value will always be non-negative. */
		public void put(int key, int value) {
			int index = hash(key);
			map.get(index).put(key, value);
		}
	
		/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		public int get(int key) {
			int index = hash(key);
			return map.get(index).get(key);
		}
	
		/** Removes the mapping of the specified value key if this map contains a mapping for the key */
		public void remove(int key) {
			int index = hash(key);
			map.get(index).remove(key);
		}
		
		private int hash(int key) {
			return key % numBuckets;
		}
	}
	
	class Pair<K, V> {
		
		private K key;
		private V value;
		
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
	}
	
	class Bucket {
		private List<Pair<Integer, Integer>> bucket;
		
		public Bucket() {
			this.bucket = new ArrayList<>();
		}
		
		public Integer get(Integer key) {
			for(Pair<Integer, Integer> pair: bucket) {
				if(pair.getKey().equals(key)) {
					return pair.getValue();
				}
			}
			return -1;
		}
		
		public void put(Integer key, Integer value) {
			for(Pair<Integer, Integer> pair: bucket) {
				if(pair.getKey().equals(key)) {
					pair.setValue(value);
					return;
				}
			}
			bucket.add(new Pair<>(key, value));
		}
		
		public void remove(Integer key) {
			for(Pair<Integer, Integer> pair: bucket) {
				if(pair.getKey().equals(key)) {
					bucket.remove(pair);
					return;
				}
			}
		}
	}
	
}