package Week5;

public class SelectionSort extends SortAlgorithm
{

	/**
	 * Sort array.
	 *
	 * @param array Array to be sorted.
	 */
    public void sort(int[] array) {
        // IMPLEMENT ME
    	for(int i=0;i<array.length -1 ;i++) {
    		int min = i;
    		for(int j=i+1;j<array.length;j++) {
    			if(array[j] < array[min]) {
    				min = j;
    			}
    		}
    		swap(array,i,min);
    	}
    	
    	
    	//loop from 0 to n-2
	    	//find the minumum value
	    	//loop from i+1 to n-1
	    		//compare [j] element to min element and replace min if smaller
	    	//swap [i] element with min element
    	
    	
    } // end of sort()

} // end of class SelectionSort
