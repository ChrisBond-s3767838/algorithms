/**
 * Array implementation that implements MyArray interface using the double approach.
 *
 * @author Jeffrey Chan, RMIT
 */
public class DynamicArrayDouble implements MyArray
{
    /** Reference to the memory of array. */
    protected int array[];
    /** Actual used size of array.  This may be different to the memory allocated
    	size of the array. */
    protected int arraySize;
    //keeps track of the amount of memory we have allocated
    
    

    /** Initial size of memory to allocate to array. */
    // We have set to 2, but you are welcome to change this.
    protected static final int initialArraySize = 2;


    /**
     * Constructor.  Ensure you understand what the logic of it is doing,
     * will help wih understanding what arraySize means.
     */
    public DynamicArrayDouble() {
        // allocate memory
    	array = new int[initialArraySize];
        // initially no stored values, so actual arraySize is 0
    	arraySize = 0;
    } // end of DynamicArrayDouble()


    /**
     * Sets/replaces the value at index.  Indices start at 0.
     *
     * @param index Position in array to set/replace value.
     *
     * @throws IndexOutOfBoundsException In index are out of bounds.
     */
    public void set(int index, int newValue) throws IndexOutOfBoundsException {
    	if (index >= arraySize || index < 0) {
            throw new IndexOutOfBoundsException("Supplied index is invalid.");
        }

        array[index] = newValue;
    } // end of set()


    /**
     * Gets/retrieves the value at index.  Indices start at 0.
     *
     * @param index Position in array to retrieve value from.
     * @return value of array at specified index.
     *
     * @throws IndexOutOfBoundsException In index are out of bounds.
     */
    public int get(int index) throws IndexOutOfBoundsException {
    	if (index >= arraySize || index < 0) {
            throw new IndexOutOfBoundsException("Supplied index is invalid.");
        }

        return array[index];
    } // end of get()


    /**
     * Add value to end of array.
     *
     * @param newValue Value to add to array.
     *
     * @throws IndexOutOfBoundsException In index are out of bounds.
     */
    public void add(int newValue) {
        
    	
    	// if not at memory size, we don't need to reallocate memory
    	if (arraySize < array.length) {
    		array[arraySize] = newValue;
    		arraySize++;
    	}
    	else {
    			//increase size of array by array.length*2
    			int newSize = array.length*2;
    			int newArray[] = new int[newSize];
    			
    			//copy all values before index
    			for (int i = 0; i < array.length; i++) {
    				newArray[i] = array[i];
    			}
    			
    			// new entry
    			newArray[array.length] = newValue;
    			
    			//refer the old array to the new array
    			array = newArray;
    			arraySize++;
    	}
    	
    	
    	
    	
    	// IMPLEMENT ME!

        // Hint, you might want to check if your current allocated memory is
        // enough to add another element without resizing.
        // If need to resize, consider what was done for DynamicArrayMinimal.

        // Recall to allocate memory for a static array, you can use:
        // array = new int[size], where size is an integer speciying how big
        // the array is.

        // Note that also java arrays cannot not be resized, so you'll need to
        // allocate memory for a new one (that is larger in size) and copy across
        // the appropriate values.

    } // end of add()


    /**
     * Insert value at position 'index'.  Indices start at 0.
     *
     * @param index Position in array to add new value to.
     * @param newValue Value to add to array.
     *
     * @throws IndexOutOfBoundsException In index are out of bounds.
     */
    public void insert(int index, int newValue) throws IndexOutOfBoundsException {
        System.out.println(index + " " + arraySize + " " + array.length);
        if (index >= arraySize || index < 0) {
            throw new IndexOutOfBoundsException("Supplied index is invalid.");
        }
        
        
        //if not at memory size, we don't need to reallocate memory
        if(arraySize < array.length) {
        	// copy all values after index
        	for (int j = arraySize; j > index; j--) {
        		array[j] = array[j-1];
        	}
        	
        	//new entry
        	array[index] = newValue;
        	arraySize++;
        }
        else {
        	//increase size of array by double
        	int newSize = array.length*2;
        	int newArray[] = new int[newSize];
        	
        	//copy all values before index
        	for (int i = 0; i < index; i++) {
        		newArray[i] = array[i];
        	}
        	
        	//copy all values after index
        	for (int j = array.length; j > index;j--) {
        		//new entry
        		newArray[index] = newValue;
        		
        		array = newArray;
        		arraySize++;
        	}
        }
        
        // IMPLEMENT ME!

        // Hint, this is similar to add, but you will need to consider how to
        // add an element at an index, rather then end of array.  You still need
        // to expand the array like add though.

        // if not at memory size, we don't need to reallocate memory
        // check if we need to allocate memory

    } // end of insert()


    /**
     * Searches for the index that contains value.  If value is not present,
     * method returns -1 (NOT_IN_ARRAY).
     * If there are multiple values that could be returned, return the one with
     * the smallest index.
     *
     * @param value Value to search for.
     * @return Index where value is located, otherwise returns -1 (NOT_IN_ARRAY).
     */
    public int search(int value) {
    	if (array != null) {
    		for (int i=0; i < arraySize; ++i) {
    			if(array[i] == value) {
    				return i;
    			}
    		}
    	}
        // IMPLEMENT ME!

        // This will return -1.  Return this when we can't find the input value.
        return NOT_IN_ARRAY;
    } // end of search()


    /**
     * Print the array from front to end (index 0 to end).
     */
    public void print() {
        if (array != null) {
            for (int i = 0; i < arraySize; i++) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println("");
    } // end of print()


    /**
     * Print the array from end to front (end to index 0).
     */
    public void reversePrint() {
        if (array != null) {
            for (int i = arraySize-1; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println("");
        
        // IMPLEMENT ME!

    } // end of reversePrint()

} // end of class DynamicArrayDouble
