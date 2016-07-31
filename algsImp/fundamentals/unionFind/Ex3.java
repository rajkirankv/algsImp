package unionFind;

import java.util.Arrays;
import java.util.Random;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

public class Ex3 {
	
/*	public static void main(String[] args) {
			
			String inputFile = args[0];
			String outputFile = args[1];
			
			String outputFile = args[0];
			
			In in = new In(inputFile);
			Out out = new Out(outputFile);
			
			int siteCount = in.readInt(); //This contains the total number of sites
			int siteCount = 1000000;
			WeightedQuickUnionUF wquUF = new WeightedQuickUnionUF(siteCount);
			Random rand = new Random();
			
			while(!in.isEmpty()) {
				int p = in.readInt();
				int q = in.readInt();
				wquUF.union(p, q);
				out.print("Access count: " + wquUF.getAccessCount() + " ");
				out.println("Current state: " + Arrays.toString(wquUF.getCurrentState()));
				out.println("Current branch sizes: " + Arrays.toString(wquUF.getSize()));
				out.println();
			}
			
			in.close(); out.close();
	}*/
	
	public static void main(String[] args) {
		
		final int siteCount = 10000000; final int pairs = 10000;
		WeightedQuickUnionUF wquUF = new WeightedQuickUnionUF(siteCount);
		Random rand = new Random();
		
		int i = 0;
		while(i <= pairs) {
			int p = rand.nextInt(siteCount);
			int q = rand.nextInt(siteCount);
			wquUF.union(p, q); i++;
		}
		StdOut.println(wquUF.getComponenentCount());
	}
}	
