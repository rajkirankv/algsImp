package symbolTables;
import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST<Key, Value> {
	
	//Linked List data structure
	private class Node {
		
		private Key key;
		private Value value;
		private Node next;
		
		//Constructor
		public Node(Key key, Value value, Node node) {
			this.key = key;
			this.value = value;
			this.next = node;
		}
	}
	
	//Class variables
	private long size;
	private Node current_node;
	
	//Constructor
	public SequentialSearchST() {
		size = 0; current_node = null;
	}
	
	//Functions
	//Insert a new key value pair
	public void put(Key key, Value value) {
		Node entry = new Node(key, value, current_node);
		current_node = entry; size++;
	}
	
	//Get the value corresponding to a given key
	public Value get(Key key) {
		Node node = current_node;
		while(!node.key.equals(key)) node = node.next;
		return node.value;
	}
	
	//Delete a key value pair given the key
/*	public void delete(Key key) {
		Node del_node = current_node;
		if(key.equals(del_node.key)) current_node = current_node.next;
		while(!key.equals(del_node.next.key)) del_node = del_node.next;
		del_node.next = del_node.next.next; size--;
	}*/
	public void delete(Key key) {
		put(key, null);
	}
	
	//Check if the given key is contained in the table
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public long size() {
		return size;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		Node n = current_node;
		while(n.next != null) {
			queue.enqueue(n.key);
			n = n.next;
		}
		queue.enqueue(n.key);
		return queue;
		
	}
	
	//main

}
