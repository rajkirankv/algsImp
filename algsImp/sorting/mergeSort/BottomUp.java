//August 22, 2016, 5:00 pm

package mergeSort;

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
}