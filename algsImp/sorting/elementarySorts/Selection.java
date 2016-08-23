package elementarySorts;

public class Selection extends Sort {
	
	public static void sort(Comparable[] a) {
		
		int N = a.length;
		
		for(int i = 0; i < N; i++) {
			
			//Assume the element at i is already the smallest among the elements to the left
			int min = i;
			
			/*Compare ith elements to each element on the left and find the index of the
			smallest element between positions i and n-1, inclusive*/
			for(int j = i+1; j < N; j++) if(less(a[j], a[min])) min = j;
			
			exch(a, min, i); /*show(a);*/
		}
	}

}
