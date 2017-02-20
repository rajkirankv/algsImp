package quickSort;

import java.util.Random;
import edu.princeton.cs.algs4.*;
import elementarySorts.Sort;
/*import mergeSort.BottomUp;*/

public class Quick {

	//Do not instantiate
	private Quick() {}
	
	public static void sort(Comparable[] a) {
		int n  = a.length;
		StdRandom.shuffle(a);
		sort(a, 0, n-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1; Comparable v = a[lo];
		while(true) {
			while(Sort.less(a[++i], v)) if(i >= hi) break;
			while(Sort.less(v, a[--j])) if(j <= lo) break;
			if(i >= j) break;
			Sort.exch(a, i, j);
		}
		Sort.exch(a, lo, j);
		return j;
	}
	
	//Unit tests
	public static void main(String[] args) {
		
		/*In in = new In(args[0]);
		
		String[] a = in.readAllStrings();
		show(a); Insertion.sort(a); assert isSorted(a);
		show(a);*/
		
		int n = 10; Random rand = new Random();
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++) arr[i] = rand.nextInt(n*10);
		Sort.show(arr); sort(arr); Sort.show(arr);
	}
}
