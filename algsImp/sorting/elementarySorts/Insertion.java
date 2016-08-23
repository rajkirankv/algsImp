package elementarySorts;

public class Insertion extends Sort {
	
	public static void sort(Comparable[] a) {
		
		int N = a.length;
		
		for(int i = 0; i < N; i++) {
			/*For each element i, compare the i+1 th element to ith element.
			 * If a[i+1] is smaller than a[i], exchange these 2 elements.
			 * Keep doing this until the current element ends up being greater
			 * than the element before it. When this happens, exit the loop. Otherwise,
			 * exit the loop when you reach the beginning of the array. At this
			 * point, all elements up to i+1 will be sorted
			 */
			for(int j = i; j > 0 && less(a[j], a[j-1]); j--) exch(a, j, j-1); show(a);
		}
	}

}
