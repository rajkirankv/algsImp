package elementarySorts;
import java.util.Random;
import edu.princeton.cs.algs4.*;

public abstract class Sort {
	
	//The main sort algorithm
	public static void sort(Comparable[] a) {};
	
	//Method for comparison
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	//Method to exchange elements
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	/*Print the array. Could be useful to view the status of the array
	at intermediate stages*/
	public static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	//Check if sorted
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) if(less(a[i], a[i-1])) return false;
		return true;
	}
	
	//Unit tests
	public static void main(String[] args) {
		
		In in = new In(args[0]);
		
		String[] a = in.readAllStrings();
		show(a); Insertion.sort(a); assert isSorted(a);
		show(a);
		
/*		int n = 10; Random rand = new Random();
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++) arr[i] = rand.nextInt(n*10);
		show(arr); Shell.sort(arr); show(arr);*/
	}

}
