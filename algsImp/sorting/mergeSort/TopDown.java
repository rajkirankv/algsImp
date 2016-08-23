//Time: 02:00 P.M, 8/19/2016

package mergeSort;

public class TopDown extends Sort {
//Do not instantiate this class
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		
		final int N = a.length;
		
/*		This auxiliary array needs to be created here rather than inside merge.
		Because if merge creates this array, it would be created every time merge 
		is called wasting space*/
		aux = new Comparable[N];
		for(int i = 0; i < N; i++) aux[i] = a[i];
		
		int n = a.length - 1; //n is the maximum index
		sort(a, 0, n/2); sort(a, n/2 + 1, n);
		merge(a, 0, n/2, n); return;
		}
	
	private static void sort(Comparable[] a, int low, int high) {
		
		int size = high - low + 1;
		if(size <= 1) return;
		else {
			sort(a, low, high/2); sort(a, high/2 + 1, high);
			merge(a, low, high/2, high);
			return;
		}
		
	}
	
	private static void merge(Comparable[] a, int low, int mid, int high) {
		
		/*int n = a.length; //n is the maximum index
		Comparable[] aux = new Comparable[n];
		for(int i = 0; i <= n; i++) aux[i] = a[i];*/
		
		/*int i, j; i = low; j = mid;*/
		
		for(int i = low,j = low,k = mid+1; i <= high; i++) {
			if(j > mid) a[low+i] = aux[k++];
			else if(k > high) a[low+i] = aux[j++];
			else if(less(aux[j], aux[k])) a[low+i] = aux[j++];
			else a[low+i] = aux[k++];
		} 
	}
	
	//Unit tests
	public static void main() {}

}
