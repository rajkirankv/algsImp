/******************************************************************************
 *  Compilation:  javac QuickUnionUF.java
 *  Execution:  java QuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-union algorithm.
 *
 ******************************************************************************/

package unionFind;
import edu.princeton.cs.algs4.*;

/**
 *  The <tt>QuickUnionUF</tt> class represents a <em>union-find data type</em>
 *  (also known as the <em>disjoint-sets data type</em>).
 *  It supports the <em>union</em> and <em>find</em> operations,
 *  along with a <em>connected</em> operation for determining whether
 *  two sites are in the same component and a <em>count</em> operation that
 *  returns the total number of components.
 *  <p>
 *  The union-find data type models connectivity among a set of <em>n</em>
 *  sites, named 0 through <em>n</em> &ndash; 1.
 *  The <em>is-connected-to</em> relation must be an 
 *  <em>equivalence relation</em>:
 *  <ul>
 *  <p><li> <em>Reflexive</em>: <em>p</em> is connected to <em>p</em>.
 *  <p><li> <em>Symmetric</em>: If <em>p</em> is connected to <em>q</em>,
 *          then <em>q</em> is connected to <em>p</em>.
 *  <p><li> <em>Transitive</em>: If <em>p</em> is connected to <em>q</em>
 *          and <em>q</em> is connected to <em>r</em>, then
 *          <em>p</em> is connected to <em>r</em>.
 *  </ul>
 *  <p>
 *  An equivalence relation partitions the sites into
 *  <em>equivalence classes</em> (or <em>components</em>). In this case,
 *  two sites are in the same component if and only if they are connected.
 *  Both sites and components are identified with integers between 0 and
 *  <em>n</em> &ndash; 1. 
 *  Initially, there are <em>n</em> components, with each site in its
 *  own component.  The <em>component identifier</em> of a component
 *  (also known as the <em>root</em>, <em>canonical element</em>, <em>leader</em>,
 *  or <em>set representative</em>) is one of the sites in the component:
 *  two sites have the same component identifier if and only if they are
 *  in the same component.
 *  <ul>
 *  <p><li><em>union</em>(<em>p</em>, <em>q</em>) adds a
 *         connection between the two sites <em>p</em> and <em>q</em>.
 *         If <em>p</em> and <em>q</em> are in different components,
 *         then it replaces
 *         these two components with a new component that is the union of
 *         the two.
 *  <p><li><em>find</em>(<em>p</em>) returns the component
 *         identifier of the component containing <em>p</em>.
 *  <p><li><em>connected</em>(<em>p</em>, <em>q</em>)
 *         returns true if both <em>p</em> and <em>q</em>
 *         are in the same component, and false otherwise.
 *  <p><li><em>count</em>() returns the number of components.
 *  </ul>
 *  <p>
 *  The component identifier of a component can change
 *  only when the component itself changes during a call to
 *  <em>union</em>&mdash;it cannot change during a call
 *  to <em>find</em>, <em>connected</em>, or <em>count</em>.
 *  <p>
 *  This implementation uses quick union.
 *  Initializing a data structure with <em>n</em> sites takes linear time.
 *  Afterwards, the <em>union</em>, <em>find</em>, and <em>connected</em>
 *  operations  take linear time (in the worst case) and the
 *  <em>count</em> operation takes constant time.
 *  For alternate implementations of the same API, see
 *  {@link UF}, {@link QuickFindUF}, and {@link WeightedQuickUnionUF}.
 *
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class QuickUnionUF {
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of components
    private long access_count;

    /**
     * Initializes an empty union-find data structure with <tt>n</tt> sites
     * <tt>0</tt> through <tt>n-1</tt>. Each site is initially in its own 
     * component.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if <tt>n &lt; 0</tt>
     */
    public QuickUnionUF(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between <tt>1</tt> and <tt>n</tt>)
     */
    public int count() {
        return count;
    }
  
    /**
     * Returns the component identifier for the component containing site <tt>p</tt>.
     *
     * @param  p the integer representing one object
     * @return the component identifier for the component containing site <tt>p</tt>
     * @throws IndexOutOfBoundsException unless <tt>0 &le; p &lt; n</tt>
     */
    public int find(int p) {
        validate(p);
        while (p != parent[p])
            p = parent[p]; access_count++;
        return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt> are in the same component;
     *         <tt>false</tt> otherwise
     * @throws IndexOutOfBoundsException unless
     *         both <tt>0 &le; p &lt; n</tt> and <tt>0 &le; q &lt; n</tt>
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
    /**
     * Merges the component containing site <tt>p</tt> with the 
     * the component containing site <tt>q</tt>.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IndexOutOfBoundsException unless
     *         both <tt>0 &le; p &lt; n</tt> and <tt>0 &le; q &lt; n</tt>
     */
    public void union(int p, int q) {
        access_count = 0; //Access counter for performance measurement
    	int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ; access_count++;
        count--;
    }
    
    //To track progress after each union
    public int[] currentState() {
    	return parent;
    }
    
    //For performance measurement
    public long accessCount() {
    	return access_count;
    }
    
    //Returns true if p is not a parent to any site. Quite a costly method
    public boolean isTip(int p) {
    	for(int i = 0; i < parent.length; i++) if(parent[i] == p) return false;
    	return true;
    }
    
	public void printTree() {
		
		final int[] tree = parent;
		StdOut.println("----------------------------------------------------------"); //To separate from the previous connection's tree
		//Go through each site in the parent tree
		for(int i = 0; i < tree.length; i++) {
			
			//If the site is either a root or in the middle, do not print anything
			if(i == find(i)) {StdOut.println(i); continue;}
			else if(!isTip(i)) continue;
			
			/*If the site is a tip, push each site in this branch
			onto a LIFO stack including the root and print that stack
			after you reach the root*/
			else {
				Stack<Integer> branch = new Stack<Integer>();
				/*Copy the i into another variable to track the tree.
				Because i is tracking the parent tree*/
				int j = i; 
				while(j != find(j)) {branch.push(j); j = tree[j];} //Keep pushing onto the stack until you reach the root
				branch.push(j); //Push the root
				for(int leaf : branch) StdOut.print(leaf + " "); StdOut.println();
			}
		}
	}
	
	public long getComponenentCount() {
    	return count;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and n-1) from standard input, 
     * where each integer represents some object;
     * if the sites are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }


}

/******************************************************************************
 *  Copyright 2002-2015, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/