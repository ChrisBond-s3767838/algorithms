package Week8Lab;


/**
 * Implementation of Mergesort.
 *
 * @author Jeffrey Chan, RMIT
 */
public class MergeSort extends SortAlgorithm
{

	/**
	 * Sort array.
	 *
	 * @param array Array to be sorted.
	 */
    public void sort(int[] array) {
        // IMPLEMENT ME
        if (array.length > 1) {
            // find mid point
            int mid = (int) Math.floor(array.length / 2);

            
            int[] rightSubArray;
         // Create new sub-arrays
            int[] leftSubArray = new int[mid];
            
            if (mid * 2 < array.length) {
                rightSubArray = new int[mid + 1];
               
            } else {
               rightSubArray = new int[mid];      
            }
            

            // copy elements array into the left and right sub-arrays
            //copy into left sub-array 
            System.arraycopy(array, 0, leftSubArray, 0, leftSubArray.length);
            System.arraycopy(array, leftSubArray.length, rightSubArray, 0, rightSubArray.length);
            
            //for(int i = 0;i<mid;i++) {
            //	leftSubArray[i] = array[i];
            //}
            //copy into right sub-array
            //for(int i = mid;i<array.length;i++) {
            //	rightSubArray[i-mid] = array[i];
            //}           
            sort(leftSubArray);
            sort(rightSubArray);
            
            //compare the finish of one and the start of the other
            if(leftSubArray[leftSubArray.length-1] > rightSubArray[0]) {
            	merge(leftSubArray,rightSubArray,array);
            }
            else {
            	concatenate(leftSubArray,rightSubArray,array);
            }
            
            
            // sort the sub-arrays
            // merge the sorted arrays

        }
    } // end of sort()

    

    
    

    private void concatenate(int[] leftSubArray, int[] rightSubArray, int[] array) {
		int arraySize = leftSubArray.length + rightSubArray.length;
    	
    	for(int i=0;i<leftSubArray.length;i++) {
        	array[i] = leftSubArray[i];	
    	}
    	for(int i=leftSubArray.length;i<arraySize;i++) {
        	array[i] = rightSubArray[i];	
    	}   	
    	
		
	}






	/**
     * Merge left and right into array.
     *
     * @param left Left sub-array.
     * @param right Right sub-array.
     * @param array Merged array.
     */
    protected void merge(int[] left, int[] right, int[] array) {
        int i = 0;
        int j = 0;
        int k = 0;

        // while there are elements in both left and right to be merged
        while (i < left.length && j < right.length) {
            // if left <= right
        			//IMPLEMENT ME!
        	
            // otherwise (right > left)

            k++;
        }

        // if one of the sub-arrays is exhausted append the rest of the other one to array
        if (i == left.length) {
            while (j < right.length) {

            }
        }
        else if (j == right.length) {
            while (i < left.length) {

            }
        }
    } // end of merge()

} // end of class MergeSort
