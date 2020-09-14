package Week6Lab;

import java.util.*;
import java.io.*;

/**
 * Compute depth first search traversal on a graph.
 *
 *  @author Jeffrey Chan, RMIT
 */
public class DFS
{
    /** Name of the class. */
    private static final String progName = "DFS";


    /**
     * Depth first search traversal of input graph g from seed vertex s.
     *
     * @param g Input graph.
     * @param s Seed vertex to start traversal from.
     *
     * @returns ArrayList of vertices, stored in the order they were visited in
     *      DFS traversal.
     */
    public static ArrayList<Integer> traverse(Graph g, int s) {
	    ArrayList<Integer> traversalOrder = new ArrayList<Integer>();

	    boolean[] marked = new boolean[g.vertNum()];
	    
	    //recursively 
    	// IMPLEMENT ME
	    //create and initialise array to mark verticies
	    for (int i=0;i<marked.length;i++) {
	    	marked[i] = false;
	    }
	    
	    //call recursive DFS function with seed vertex s
	    recursiveDFSMethod(g,s,marked,traversalOrder);

    	return traversalOrder;
    } // end of traverse()

    // RECURSIVE DFS METHOD
    //mark seed as visited
    //add seed to traveralOrder
    //iterate over all neighboring verticies
    	//if neighbour not marked then call recursive function
    	//else nothing
    
    private static void recursiveDFSMethod(Graph g, int v, boolean[] marked, ArrayList<Integer> traversalOrder) {
    	marked[v] = true;
    	// use this instead of 'order' to store the order we visit the nodes.
    	traversalOrder.add(v);
    	for(int w : g.neighbours(v)) {
    		if (!marked[w]) {
    			recursiveDFSMethod(g,w,marked,traversalOrder);
    		}
    	}
    	
    }
    
    
    
    /**
     * Print out usage message and exits from program.
     */
    protected static void usage() {
    	System.err.println(DFS.progName + ": <input graph file> <starting vertex>");
    	System.exit(1);
    }


    /**
     * Perform DFS traversal for input graph.
     */
    public static void main(String[] args) {
    	if (args.length != 2) {
    		usage();
    	}

    	try {
            // input graph
            InputStream in = new FileInputStream(args[0]);
            Graph g = new Graph(in);

            // seed vertex
            int s = Integer.parseInt(args[1]);

            // perform DFS
            ArrayList<Integer> traversalOrder = DFS.traverse(g, s);

            // print out the traversal order of the BFS
            Iterator<Integer> it = traversalOrder.iterator();
            while (it.hasNext()) {
    		System.out.print(it.next() + " ");
            }

            System.out.println("");
    	}
    	catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
    	}
    } // end of main()

} // end of class DFS
