package unionFind;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

public class Ex2 {
	
	/*public static void main(String[] args) {
			
			String inputFile = args[0];
			String outputFile = args[1];
			
			In in = new In(inputFile);
			Out out = new Out(outputFile);
			
			int siteCount = in.readInt(); //This contains the total number of sites
			QuickUnionUF quUF = new QuickUnionUF(siteCount);
			
			while(!in.isEmpty()) {
				int p = in.readInt();
				int q = in.readInt();
				quUF.union(p, q);
				out.print(quUF.accessCount() + ": ");
				out.println(Arrays.toString(quUF.currentState()));
				quUF.printTree();
			}
			
			in.close(); out.close();
	}*/
	
	public static void main(String[] args) {
		
		final int siteCount = 10000000; final int pairs = 10000;
		Random rand = new Random();
		QuickUnionUF quUF = new QuickUnionUF(siteCount);
		
		int i = 0;
		while(i <= pairs) {
			int p = rand.nextInt(siteCount);
			int q = rand.nextInt(siteCount);
			quUF.union(p, q); i++;
		}
		StdOut.println(quUF.getComponenentCount());
	}

}
