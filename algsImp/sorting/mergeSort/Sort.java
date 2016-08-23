package mergeSort;
import java.util.Random;
import edu.princeton.cs.algs4.*;

public abstract class Sort {
	
	//The main sort algorithm
	public static void sort(Comparable[] a) {};
	
	//Method for comparison
	protected static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	//Method to exchange elements
	/*protected static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}*/
	
	/*Print the array. Could be useful to view the status of the array
	at intermediate stages*/
	protected static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	//Check if sorted
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) if(less(a[i], a[i-1])) return false;
		return true;
	}
	
	/*Given an array and the indices of first, last and mid elements the arrays defined
	by whom are sorted, merge them so that the resulting merged array is also sorted*/
	/*protected static void merge(Comparable[] a, int low, int mid, int high) {
		
		int n = a.length; //n is the maximum index
		Comparable[] aux = new Comparable[n];
		for(int i = 0; i <= n; i++) aux[i] = a[i];
		
		int i, j; i = low; j = mid;
		
		for(int i = 0,j = low,k = mid+1; i <= n; i++) {
			if(j > mid) a[low+i] = aux[k++];
			else if(k > high) a[low+i] = aux[j++];
			else if(less(aux[j], aux[k])) a[low+i] = aux[j++];
			else a[low+i] = aux[k++];
		} 
	}*/
	
	//Unit tests
	public static void main(String[] args) {
		
/*		In in = new In(args[0]);
		
		String[] a = in.readAllStrings();
		show(a); Insertion.sort(a); assert isSorted(a);
		show(a);*/
		
		int n = 10; Random rand = new Random();
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++) arr[i] = rand.nextInt(n*10);
		show(arr); BottomUp.sort(arr); show(arr);
	}

}
