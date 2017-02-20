package priorityQueues;
import edu.princeton.cs.algs4.MaxPQ;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ex2_4_1 {
	
	/*Don't instantiate*/
	private Ex2_4_1() {}
	
	public static void main(String[] args) {
		
		/*File inputFile = new File("/Users/stan/Documents/data/algs/PQ");
		Scanner inputScanner;
		try {
			inputScanner = new Scanner(inputFile);
			String inputString = inputScanner.useDelimiter("\\Z").next();
			inputScanner.close();
			MaxPQ<Character> PQ = new MaxPQ<Character>();
			for(int i = 0; i < inputString.length(); i++) {
				char c = inputString.charAt(i);
				if(c == '*') System.out.println(PQ.delMax());
				else PQ.insert((Character) c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/	
		String inputString = "P R I O * R * * I * T * Y * * * Q U E * * * U * E";
		MaxPQ<Character> PQ = new MaxPQ<Character>();
		for(int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			if(c == '*') System.out.print(PQ.delMax() + " ");
			else PQ.insert((Character) c);
		}
	}

}