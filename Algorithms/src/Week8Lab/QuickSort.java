package Week8Lab;


/**
 * Implementation of Quicksort, same as the lecture notes.
 * Use first element as pivot.
 *
 * @author Jeffrey Chan, RMIT
 */
public class QuickSort extends SortAlgorithm
{

	/**
	 * Sort array.
	 *
	 * @param array Array to be sorted.
	 */
    public void sort(int[] array) {
    	sort(array, 0, array.length-1);
    } // end of sort()


    /**
     * In-place sort, used leftIndex and rightIndex to specify the partition in question.
     *
     * @param array Array to be sorted.
     * @param leftIndex The leftmost position to sort from (inclusive).
     * @param leftIndex The rightmost position to sort to (inclusive).
     */
    protected void sort(int[] array, int leftIndex, int rightIndex) {
		// IMPLEMENT ME
    	//check if leftIndex < rightIndex, otherwise only single elements
    		//call partition method on array, leftIndex,rightIndex
    	// if split index +1 is less than rightIndex
    		//recursively call sort on right partition
    	
    } // end of sort()


    /**
     * Quicksort partition function.  Swap and divide into two partitions.
     *
     * @param array Array to be sorted.
     * @param leftIndex The leftmost position to sort from (inclusive).
     * @param leftIndex The rightmost position to sort to (inclusive).
     *
     * @return Index of array where the pivot is placed into.
     */
    protected int partition(int[] array, int leftIndex, int rightIndex) {
		// IMPLEMENT ME
    		//simple implementation
    		//set pivot as leftIndex element
    		// set i = leftIndex and j = rightIndex + 1
    		// while i <= j
    			//while i element less than pivot and i less than rightIndex
    			//increment i
    			// while j element greater than pivot
    				//decrement j
    			//swap i element with j element
    	
    	//swap i element with j element
    	
    	//swap pivot element with j element
    	
    	//return j
    	
		// DUMMY return value
		return -1;
    } // end of partition()

} // end of class QuickSort
