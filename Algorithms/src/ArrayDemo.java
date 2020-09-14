import java.util.Scanner;

/**
 * Demonstration class for dynamic arrays.
 * Provides command parsing and calling appropriate methods for the arrays.
 * DO NOT CHANGE.
 *
 *  @author Jeffrey Chan, RMIT
 */
public class ArrayDemo
{

    /**
     * Print out help menu.
     */
    public static void printHelp()
    {
        System.out.println("Available commands:\n"
                    + "    get <index>\n"
                    + "    set <index> <value>\n"
                    + "    add <value>\n"
                    + "    insert <index> <value>\n"
                    + "    search <value>\n"
                    + "    print\n"
                    + "    reversePrint\n"
                    + "    help\n"
                    + "    quit|end\n"
                    );
    }


    /**
     * Get next command/operation from file.
     *
     * @param array Reference to MyArray array which the commands will be executed on.
     */
    public static void processOperations(MyArray array)
    {
        Scanner is = new Scanner(System.in);

        // keep looping until we receive a quit or end command
        while( is.hasNext() ) {
            String command = is.next();

            // get operation
            if( command.compareTo("get") == 0 ) {
                if (is.hasNextInt()) {
                    int index = is.nextInt();
                    try {
                    	System.out.println(array.get(index));
                    } catch(IndexOutOfBoundsException e) {
                    	System.err.println(e.getMessage());
                    }
                }
            }
            // set operation
            else if( command.compareTo("set") == 0 ) {
                if (is.hasNextInt()) {
                    int index = is.nextInt();
                    if (is.hasNextInt()) {
                    	int value = is.nextInt();
                    	try {
                    		array.set(index, value);
                    	} catch(IndexOutOfBoundsException e) {
                    		System.err.println(e.getMessage());
                    	}
                    }
                }
            }
            // add operation
            else if( command.compareTo("add") == 0 ) {
                if (is.hasNextInt()) {
                    int value = is.nextInt();
                    try {
                    	array.add(value);
                    } catch(IndexOutOfBoundsException e) {
                    	System.err.println(e.getMessage());
                    }
                }
            }
            // insert operation
            else if( command.compareTo("insert") == 0 ) {
                if (is.hasNextInt()) {
                    int index = is.nextInt();
                    if (is.hasNextInt()) {
                    	int value = is.nextInt();
                    	try {
                    		array.insert(index, value);
                    	} catch(IndexOutOfBoundsException e) {
                    		System.err.println(e.getMessage());
                    	}
                    }
                }
            }
            // search operation
            else if( command.compareTo("search") == 0  ) {
                if (is.hasNextInt()) {
                    int value = is.nextInt();
                    int searchIndex = array.search(value);
                    if (searchIndex != array.NOT_IN_ARRAY) {
                    	System.out.println("Search key found at index " + searchIndex + ".");
                    }
                    else {
                    	System.out.println("Key not found.");
                    }
                }
            }
            // print operation
            else if( command.compareTo("print") == 0  ) {
                array.print();
            }
            // reversePrint operation
            else if( command.compareTo("reversePrint") == 0  ) {
                array.reversePrint();
            }
            // quit operation
            else if( command.compareTo("quit") == 0 || command.compareTo("end") == 0 ) {
                break;
            }
            // help operation
            else if ( command.compareTo("help") == 0) {
                printHelp();
            }
            // unknown operation - print out error message
            else {
                System.err.println("Did not recognize command. Enter valid command.");
                printHelp();
            }
        } // end of while

        is.close();
    } // end of processOperations()



    /**
     * Main method.
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            printHelp();
            System.exit(1);
        }

        // determine which array to construct
        MyArray array = null;
        if (args[0].compareTo("minimal") == 0) {
            array = new DynamicArrayMinimal();
        }
        else if (args[0].compareTo("double") == 0) {
            array = new DynamicArrayDouble();
        }
        else {
            printHelp();
            System.exit(1);
        }

        // process the commands
        System.out.println("Enter command:");
        processOperations(array);
    } // end of main()

} // end of class ArrayDemo
