package Week8Lab;

import java.io.*;
import java.util.*;

/**
 * Demonstrate the different sorting algorithms.
 *
 * @author Jeffrey Chan
 */
public class SortDemo
{
    protected static final String progName = "SortDemo";

    /** Different modes that program can run. */
    public enum Mode {
      	BUB,
      	QUICK,
      	MERGE
    }


    /**
     * Print usage information.
     *
     * @param progName Program name.
     */
    protected static void printUsage(String progName) {
      	System.err.println("USAGE: " + progName + " [sort method] [input file]");
      	System.err.println("  sort methods [bubble, quick, merge]");
      	System.err.println("EXAMPLE: " + progName + " quick random.txt");
    } // end of printUsage()


    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try {
            // not enough arguments
            if (args.length != 2) {
                printUsage(progName);
                System.exit(1);
            }

            // sorting algorithm to be used
            String algorithmUsed = args[0];
            // input file to be sorted
            String fileName = args[1];


            File inFile = new File(fileName);
            Scanner in = new Scanner(inFile);

            // buffer to read in data
            ArrayList<Integer> buffer = new ArrayList<Integer>();

            while (in.hasNextInt()) {
                buffer.add(Integer.valueOf(in.nextInt()));
            }

            // create array of int
            int[] array = new int[buffer.size()];
            // copy buffer to array
            Iterator bit = buffer.iterator();
            int j = 0;
            while (bit.hasNext()) {
                array[j] = (Integer) bit.next();
                j++;
            }


            // buffer memory no longer needed
            buffer = null;

            // figure out with sorting algorithm we are using
            SortAlgorithm sortAlgor = null;
            switch(algorithmUsed) {
                case "bubble":
                    sortAlgor = new BubbleSort1();
                    break;
                case "merge":
                    sortAlgor = new MergeSort();
                    break;
                case "quick":
                    sortAlgor = new QuickSort();
                    break;
                default:
                    System.err.println("Error: " + algorithmUsed + "is invalid.");
                    array = null;
                    printUsage(progName);
                    System.exit(1);
            }

            // timer
            long startTime = System.nanoTime();

            // do the sorting
            sortAlgor.sort(array);

            long endTime = System.nanoTime();


            // print out sorted array
            for (int i = 0; i < array.length; i++) {
            	System.out.print(array[i] + " ");
            }
            System.out.println("");
            

            // calculate time elapsed
            double timeElapsed = (endTime - startTime) / Math.pow(10, 9);
            System.out.println("Time elapsed (secs): " + timeElapsed);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            printUsage(progName);
        }

    } // end of main()

} // end of class SortDemo
