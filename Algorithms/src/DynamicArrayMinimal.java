/**
 * Array implementation that implements MyArray interface using a minimal approach.
 *
 * @author Jeffrey Chan, RMIT
 */
public class DynamicArrayMinimal implements MyArray
{
    /** Reference to the memory of array. */
    protected int array[];


    /**
     * Constructor.
     */
    public DynamicArrayMinimal() {
        // No memory allocated to array, so we set the reference to null and
        // only allocate memory when we add an element.
    	array = null;
    } // end of DynamicArray()


    /**
     * Sets/replaces the value at index.  Indices start at 0.
     *
     * @param index Position in array to set/replace value.
     *
     * @throws IndexOutOfBoundsException In index are out of bounds.
     */
    public void set(int index, int newValue) throws IndexOutOfBoundsException {
    	if (index >= array.length || index < 0) {
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
    	if (index >= array.length || index < 0) {
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

    	//Check if Array Exists
    	
	    	//if array does not exist
	    		//allocate array size one
	    	
	    		// else increase array by 1 
	    			//find the size
	  
	    			//create a new array of size +1
    	
    	
	    			//copy contents of array to new array
	    			//add new element to array
	    			//update reference of array to point to new array
    	
    	
    	
    	
    	
        // IMPLEMENT ME!

        // Hint, you might want to check if array has been allocated memory first,
        // then consider each of the two cases (has allocated, has not) and handle
        // them accordingly

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
        System.out.println(index + " " + array.length);
        if (index >= array.length || index < 0) {
            throw new IndexOutOfBoundsException("Supplied index is invalid.");
        }

        
              
    	//Check if Array Exists
        if (array.length == 0) {
        	//if array does not exist
    		//allocate array size one
        	array = new int[1];
            array[0] = newValue;
        }
        	
        
        
        else {
    		// else increase array by size 1
			//find the size
			//create a new array of size +1        
        	
        	

            int[] newArray = new int[array.length+1];
            for(int i=0; i<newArray.length; i++) {
            	
            }
        	
        	
        }


        			
        
        
        
    	
        
        			//copy up until index
        			//insert new element
        			//copy all values after index
        
        
        
        
        
        
        
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

    	//check array exists
    		//iterate along array
    			//check if array[i] == value
    				//return i
    				//else will go to "return"
    	
    	
    	
    	
        // IMPLEMENT ME!

        // This will return -1.  Return this when we can't find the input value.
        return NOT_IN_ARRAY;
    } // end of search()


    /**
     * Print the array from front to end (index 0 to end).
     */
    public void print() {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
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
            for (int i = array.length -1; i < array.length; i--) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println("");    	
    	
    	
        // IMPLEMENT ME!

    } // end of reversePrint()

} // end of class DynamicArrayMinimal
