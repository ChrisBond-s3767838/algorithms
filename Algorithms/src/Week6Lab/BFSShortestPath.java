package Week6Lab;

import java.util.*;
import java.io.*;

/**
 * Compute the shortest path distance using breadth first search.
 *
 * @author Jeffrey Chan, RMIT
 */
public class BFSShortestPath
{
    /** Class name. */
    private static final String progName = "BFSShortestPath";

    /** Distance value for source and target vertex pairs that are disconnected. */
    protected static final int disconnectedDist = -1;


    /**
     * Compute the shortest path distance between the source
     *
     * @param g Input Graph.
     * @param s Source vertex.
     * @param t Target vertex.
     *
     * @return Shortest path distance between s and t.  If they are disconnected, then return BFSShortestPath.disconnectedDist.
     */
    public static int spd(Graph g, int s, int t) {
    	ArrayList<Integer> traversalOrder = new ArrayList<Integer>();
    	boolean[] marked = new boolean[g.vertNum()];
    	// IMPLEMENT ME
	    //create and initialise array to mark verticies
    	for (int i=0;i<marked.length;i++) {
    		marked[i] = false;
    	}
    	
    	
    	//create queue and add seed vertex to queue
    	Queue<Pair> q = new ArrayDeque<Pair>();
    	marked[s] = true;
    	q.add(new Pair(s,0));
    	//while not Queue is empty
    	while (!q.isEmpty()) {
    		Pair p = q.remove();
    		int v = p.getVert();
    		int dist = p.getDist();
    		
    		//found target vertex
    		if (v==t ) {
    			return dist;
    		}
    		
    		//else keep expanding to neighbours
    	
    		for (int w : g.neighbours(v)) {
        			//if neighbour is not visited then add to queue
    				if (!marked[w]) {
    					marked[w] = true;
    					q.add(new Pair(w,dist+1));
    				}
    			
    					//it will keep looping until end
    		}
    	}

    	return disconnectedDist;
    } // end of traverse()


    /**
     * Print out usage messge and exits from program.
     */
    protected static void usage() {
    	System.err.println(BFSShortestPath.progName + ": <input graph file> <source vertex> <target vertex>");
    	System.exit(1);
    }


    /**
     * Compute shortest path distance using BFS for input graph.
     */
    public static void main(String[] args) {
    	if (args.length != 3) {
    		usage();
    	}

    	try {
            // input graph
    		InputStream in = new FileInputStream(args[0]);
    		Graph g = new Graph(in);

            // source vertex
    		int source = Integer.parseInt(args[1]);
            // target vertex
    		int target = Integer.parseInt(args[2]);

            // compute the shortest path distance between source and target
    		int spDist = BFSShortestPath.spd(g, source, target);

            // check if the two vertices are connected
    		if (spDist == disconnectedDist) {
    			System.out.println("Source " + source + " and Target " + target + " are disconnected.");
    		}
    		else {
    			System.out.println("Distance between Source " + source + " and Target " + target + " is " + spDist);
    		}

    	}
    	catch (FileNotFoundException e) {
    		System.err.println(e.getMessage());
    	}
    } // end of main()

} // end of class BFS-ShortestPaths


/**
 * Class implement a (vertex, distance) pair.
 *
 * @author Jeffrey Chan
 */
class Pair {
	private Integer mVert;
	private Integer mDist;

	public Pair(Integer v, Integer dist) {
		mVert = v;
		mDist = dist;
	}


	public Integer getVert() {
		return mVert;
	}

	public Integer getDist() {
		return mDist;
	}

} // end of class Pair
