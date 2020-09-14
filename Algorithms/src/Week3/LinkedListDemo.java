package Week3;

import java.util.Scanner;


/**
 * Demonstration class for linked list.
 * Provides command parsing and calling appropriate methods for the linked list.
 * DO NOT CHANGE.
 *
 *  @author Jeffrey Chan, RMIT
 */
public class LinkedListDemo
{

    /**
     * Print out help menu.
     */
    public static void printHelp()
    {
        System.out.println("Available commands:\n"
                    + "    help\n"
                    + "    add <value>\n"
                    + "    insert <index> <value>\n"
                    + "    remove <value>\n"
                    + "    removeByIndex <index>\n"
                    + "    search <value>\n"
                    + "    min\n"
                    + "    max\n"
                    + "    print\n"
                    + "    reversePrint\n"
                    + "    quit|end\n"
                    );
    } // end of printHelp()


    /**
     * Get next command/operation from file.
     *
     * @param list Reference to list which the commands will be executed on.
     */
    public static void processOperations(MyList list)
    {
        Scanner is = null;
        try {
            is = new Scanner(System.in);

            // get next operation
            while( is.hasNext() ) {
                String command = is.next();

                // help operation
                if( command.compareTo("help") == 0 ) {
                    printHelp();
                }
                // add operation
                else if( command.compareTo("add") == 0 ) {
                    if (is.hasNextInt()) {
                        int value = is.nextInt();
                        list.add(value);
                    }
                }
                // insert operation
                else if( command.compareTo("insert") == 0 ) {
                    if (is.hasNextInt()) {
                        int index = is.nextInt();
                        if (is.hasNextInt()) {
                    	       int value = is.nextInt();
                    	   try {
                    	       list.insert(index, value);
                    	   } catch(IndexOutOfBoundsException e) {
                    	          System.err.println(e.getMessage());
                    	   }
                       }
                   }
               }
               // remove operation
               else if( command.compareTo("remove") == 0  ) {
                   if (is.hasNextInt()) {
                       int value = is.nextInt();
                       list.remove(value);
                   }
               }
               // removeByIndex operation
               else if( command.compareTo("removeByIndex") == 0  ) {
                   if (is.hasNextInt()) {
                       int index = is.nextInt();
                       try {
                           list.remove(index, false);
                       } catch(IndexOutOfBoundsException e) {
                	       System.err.println(e.getMessage());
                	   }
                   }
               }
               // search operation
               else if( command.compareTo("search") == 0  ) {
                   if (is.hasNextInt()) {
                       int value = is.nextInt();
                       int index = list.search(value);
                       if (index == list.NOT_IN_ARRAY) {
                           System.out.println("Key not found.");
                       }
                       else {
                           System.out.println("Key found at index " + index);
                       }
                   }
               }
               // min operation
               else if( command.compareTo("min") == 0  ) {
                   int minKey = list.min();
                   System.out.println("Min key = " + minKey);
               }
               // max operation
               else if( command.compareTo("max") == 0 ) {
                   int maxKey = list.max();
                   System.out.println("Max key = " + maxKey);
               }
               // print operation
               else if( command.compareTo("print") == 0  ) {
                   list.print();
               }
               // reversePrint operation
               else if( command.compareTo("reversePrint") == 0  ) {
                   list.reversePrint();
               }
               // quit operation
               else if( command.compareTo("quit") == 0 || command.compareTo("end") == 0 ) {
                   break;
               }
               // unknown operation
               else {
                   System.err.println("Did not recognize command. Enter valid command.");
                   printHelp();
               }
           } // end of while
        }
        finally {
            if (is != null) {
                is.close();
            }
        } // end of try-catch block

    } // end of processOperations()



    /**
     * Main method.
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            printHelp();
            System.exit(1);
        }

        // determine which list to construct
        MyList list = null;
        if (args[0].compareTo("single") == 0) {
            list = new SimpleLinkedList();
        }
        else if (args[0].compareTo("double") == 0) {
            list = new DoubleLinkedList();
        }
        else {
            printHelp();
            System.exit(1);
        }

        // process the commands
        System.out.println("Enter command:");
        processOperations(list);
    } // end of main()

} // end of class LinkedListDemo

