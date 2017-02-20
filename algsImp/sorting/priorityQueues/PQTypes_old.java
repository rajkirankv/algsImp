package priorityQueues;

public class PQTypes_old<Key extends Comparable<Key>> {
	
	//Fields
	/*Choose array implementation if N is provided, otherwise choose Linked List*/
	Key[] OArr, UOArr; LinkedList OLL; LinkedList UOLL;
	/*Set DataType = 0 for unordered and 1 for ordered*/
	private final int DataType = 0; private int n = 0; /*number of elements in the array*/
	private int Nmax; /*Maximum priority queue size as specified by the client*/
	
	//Constructors
	public PQTypes_old(int N) {
		Nmax = N;
		switch(DataType) {
		case 0:
			UOArr = (Key[]) new Object[N]; break;
		case 1:
			OArr = (Key[]) new Object[N]; break;
		default:
			System.out.println("Choose whether the implementation is ordered or unrordered"); break;
		}
	}
	
	public PQTypes_old() {
		switch(DataType) {
		case 0:
			UOLL = new LinkedList(); break;
		case 1:
			OLL = new LinkedList(); break;
		default:
			System.out.println("Not a valid underlying data structure"); break;
			}
	}
	
	//Instance Methods
	public Key DelMax(Key[] a) {
		if(n == 0) throw new ArrayIndexOutOfBoundsException();
		if(DataType == 0) {
			 swim(UOArr, n); Key temp = a[1]; exch(); a[n--] = null; return temp;}
		else {
			 exch(a, 1, n); sink(a, 1); Key temp = a[n]; a[n--] = null; return temp;}
	}
	
	public void insert(Key item) {
		if(n+1 > Nmax) throw new ArrayIndexOutOfBoundsException();
		if(DataType == 0) UOArr[++n] = item;
		else {
			UOArr[++n] = item; swim(OArr, n);}	
	}
	
	//Private methods
	/*private void resize(Key[] a) {
		int n = a.length;
		Key[] temp = (Key[]) new Object[n+1];
		if(n <= Nmax/2)
			for(int i = 0; i <= n; i++)
				temp[i] = a[i];
		
	}*/
	
	private boolean less(Key[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
	private boolean less(LinkedList a, int i, int j) {
		/*return a[i].compareTo(a[j]) < 0;*/
	}
	
	private void exch(Key[] a, int i, int j) {
		Key temp = a[i]; a[i] = a[j]; a[j] = temp; temp = null;
	}
	private void exch(LinkedList a, int i, int j) {
		/*Key temp = a[i]; a[i] = a[j]; a[j] = temp; temp = null;*/
	}
	
	private void swim(Key[] a, int i) {
		while(i > 0 && less(a, i/2, i))
				exch(a, i/2, i);
	}
	private void swim(LinkedList a, int i) {
	/*	while(i > 0 && less(a, i/2, i))
				exch(a, i/2, i);*/
	}
	
	private void sink(Key[] a, int i) {
		int j = 2*i;
		while(j <= n) {
			int max = less(a, j, j+1) ? j+1 : j;
			if(!less(a, i, max)) break;
			exch(a, i, max);
			i = max; j = 2*i;
		}
	}
	private void sink(LinkedList a, int i) {
	/*	int j = 2*i;
		while(j <= n) {
			int max = less(a, j, j+1) ? j+1 : j;
			if(!less(a, i, max)) break;
			exch(a, i, max);
			i = max; j = 2*i;
		}*/
	}
	
	//Private classes
	private class LinkedList {
		Key item; LinkedList link;
	} 

}
