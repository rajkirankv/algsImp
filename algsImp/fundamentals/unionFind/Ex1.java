package unionFind;
import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.*;

public class Ex1 {
	/*public static void main(String[] args) {
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		In in = new In(inputFile);
		Out out = new Out(outputFile);
		
		int siteCount = in.readInt(); //This contains the total number of sites
		QuickFindUF qfUF = new QuickFindUF(siteCount);
		
		while(!in.isEmpty()) {
			int p = in.readInt();
			int q = in.readInt();
			qfUF.union(p, q);
			out.print(qfUF.accessCount() + ": ");
			out.println(Arrays.toString(qfUF.currentState()));			
		}
		
		in.close(); out.close();
	}*/
	
	public static void main(String[] args) {
		
		final int siteCount = 10000000; final int pairs = 10000;
		Random rand = new Random();
		QuickFindUF qfUF = new QuickFindUF(siteCount);
		
		int i = 0;
		while(i <= pairs) {
			int p = rand.nextInt(siteCount);
			int q = rand.nextInt(siteCount);
			qfUF.union(p, q); i++;
		}
		StdOut.println(qfUF.getComponenentCount());
	}	
}
