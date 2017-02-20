package symbolTables;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ST<Key extends Comparable<Key>, Value> {
	
	private TreeMap<Key, Value> st;
	
	public ST() {
		st = new TreeMap<Key, Value>(); 
	}
	
	public void put(Key key, Value value) {
		if(key == null)   throw new NullPointerException("Called put() with null key");
		if(value == null) st.remove(key);
		else			  st.put(key, value);					
	}
	
	public Value get(Key key) {
		if(key == null) throw new NullPointerException("Key can't be null");
		return st.get(key); 
	}
	
	public void delete(Key key) {
		if(key == null) throw new NullPointerException("Key can't be null");
		st.remove(key);
	}
	
	public boolean contains(Key key) {
		if(key == null) throw new NullPointerException("Key can't be null");
		return st.containsKey(key);
	}
	
	public boolean isEmpty() {
		return st.size() == 0;
	}

	public int size() {
		return st.size();
	}
	
	public Key min() {
		return st.firstKey();
	}
	
	public Key max() {
		return st.lastKey();
	}
	
	public Key floor(Key key) {
		if(key == null) throw new NullPointerException("Key can't be null");
		return st.floorKey(key);
	}
	
	public Key ceiling(Key key) {
		if(key == null) throw new NullPointerException("Key can't be null");
		return st.ceilingKey(key);
	}
	
	public void deleteMin() {
		st.remove(this.min());
	}
	
	public void deleteMax() {
		st.remove(this.max());
	}
	
	public Iterable<Key> keys() {
		return st.keySet();
	}
	
	public static void main(String[] args) {
		ST<String, Integer> st = new ST<String, Integer>();
		//read
		for(int i = 0; !StdIn.isEmpty(); i++) {
			st.put(StdIn.readString(), i);
		}
		//write
		for(String s : st.keys()) {
			StdOut.println(s + ": " + st.get(s));
		}
		
	}
}













