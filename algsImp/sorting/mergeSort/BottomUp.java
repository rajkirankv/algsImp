//August 22, 2016, 5:00 pm

package mergeSort;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class BottomUp extends Sort {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		
		final int N = a.length;
		
/*		This auxiliary array needs to be created here rather than inside merge.
		Because if merge creates this array, it would be created every time merge 
		is called wasting space*/
		aux = new Comparable[N];
		for(int i = 0; i < N; i++) aux[i] = a[i];
		
		for(int size  = 1; size < N; size += size) {
			for(int low = 0; low < N - size; low += size + size) {
				merge(a, low, low + size - 1, Math.min(low + size + size - 1, N - 1));
				//RAJ: To reflect the status of the original array after every merge
		        System.out.println(Arrays.toString(a));
			}
		}
	}

	private static void merge(Comparable[] a, int low, int mid, int high) {
		
		/*int n = a.length; //n is the maximum index
		Comparable[] aux = new Comparable[n];
		for(int i = 0; i <= n; i++) aux[i] = a[i];*/
		
		/*int i, j; i = low; j = mid;*/
		
		for(int i = low,j = low,k = mid+1; i <= high; i++) {
			if(j > mid) a[i] = aux[k++];
			else if(k > high) a[i] = aux[j++];
			else if(less(aux[j], aux[k])) a[i] = aux[j++];
			else a[i] = aux[k++];
		} 
	}
	

    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        show(a);
    }
}

}
