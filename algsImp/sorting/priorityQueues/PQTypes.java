package priorityQueues;
import java.util.Random;

public class PQTypes<Key extends Comparable<Key>> {
	private Key[] pq; 
	private int n = 0; /*Current number of elements in the priority queue*/
	private final int N; /*Current number of elements in the priority queue*/
	
	public PQTypes(int Nmax) {
		N = Nmax; pq = (Key[]) new Comparable[N];
	}
	
	public void insert(Key key) {
		pq[++n] = key; swim(); /*Eager method*/
		for(int i = 0; i < pq.length; i++) System.out.print(pq[i] + " ");
		System.out.println();
		return;
	}
	
	public Key delMax() {
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
		Key maxKey = pq[1]; exch(1, n); sink(); pq[n--] = null; 
		/*for(int i = 0; i < pq.length; i++) System.out.print(pq[i] + " ");*/
		System.out.println(maxKey);
		return maxKey;
	}
	
	//Helper methods
	private void swim() {
		for(int j = n; j > 1; j--) if(less(j-1, j)) exch(j-1, j);}
	
	private void sink() {
		for(int j = 1; j < n; j++) if(less(j, j+1)) exch(j, j+1);}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;}
	
	private void exch(int i, int j) {
		Key temp = pq[i]; pq[i] = pq[j]; pq[j] = temp; temp = null;}
	
	private boolean isEmpty() {
		return n == 0;}
	
	public static void main(String[] args) {
		Random rand = new Random(47);
		PQTypes<Integer> pq = new PQTypes<Integer>(10);
		for(int i = 0; i < 3; i++) {pq.insert(rand.nextInt(1000));}
		pq.delMax();
	}
}
















