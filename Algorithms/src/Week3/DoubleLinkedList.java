package Week3;

/**
 * Double linked list that implements interface MyList.
 *
 * @author Jeffrey Chan, RMIT
 */
public class DoubleLinkedList implements MyList
{
	/** Reference to head of list. */
    protected Node mHead;
    /** Reference to tail of list. */
    protected Node mTail;

    /** Length of list. */
    protected int mLength;


    /**
     * Default constructor.
     */
    public DoubleLinkedList() {
        mHead = null;
        mTail = null;
        mLength = 0;
    } // end of DoubleLinkedList()


    /**
     * Add a new value to the start of the list.
     *
     * @param newValue Value to add to list.
     */
    public void add(int newValue) {
    	// IMPLEMENT ME!
    } // end of add()


    /**
     * Insert value (and corresponding node) at position 'index'.  Indices start at 0.
     *
     * @param index Position in list to add new value to.
     * @param newValue Value to add to list.
     *
     * @throws IndexOutOfBoundsException Index is out of bounds.
     */
    public void insert(int index, int newValue) throws IndexOutOfBoundsException {
        if (index >= mLength || index < 0) {
            throw new IndexOutOfBoundsException("Supplied index is invalid.");
        }

        // IMPLEMENT ME!
    } // end of insert()


    /**
     * Returns the value stored in node at position 'index' of list.
     *
     * @param index Position in list to get new value for.
     * @return Value of element at specified position in list.
     *
     * @throws IndexOutOfBoundsException Index is out of bounds.
     */
    public int get(int index) throws IndexOutOfBoundsException {
        if (index >= mLength || index < 0) {
            throw new IndexOutOfBoundsException("Supplied index is invalid.");
        }

        Node currNode = null;
        if (index < Math.ceil(mLength / 2)) {
            currNode = mHead;
            for (int i = 0; i < index; ++i) {
                currNode = currNode.getNext();
            }
        }
        else {
            currNode = mTail;
            for (int i = mLength-1; i > index; --i) {
                currNode = currNode.getPrev();
            }
        }

        return currNode.getValue();
    } // end of get()


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
        Node currNode = mHead;
        for (int i = 0; i < mLength; ++i) {
        	if (currNode.getValue() == value) {
        		return i;
        	}
            currNode = currNode.getNext();
        }

        return NOT_IN_ARRAY;
    } // end of search()


    /**
     * Delete given value from list (delete first instance found).
     *
     * @param value Value to remove.
     * @return True if deletion was successful, otherwise false.
     */
    public boolean remove(int value) {

        // IMPLEMENT ME!

        return false;
    } // end of remove()


    /**
     * Delete value (and corresponding node) at position 'index'.  Indices start at 0.
     *
     * @param index Position in list to get new value for.
     * @param dummy Dummy variable, serves no use apart from distinguishing overloaded methods.
     * @return Value of node that was deleted.
     *
     * @throws IndexOutOfBoundsException Index is out of bounds.
     */
    public int remove(int index, boolean dummy) throws IndexOutOfBoundsException {
        if (index >= mLength || index < 0) {
            throw new IndexOutOfBoundsException("Supplied index is invalid.");
        }

        // IMPLEMENT ME!


        // PLACHOLDER: UPDATE (DUMMY VALUE)
        return -1;
    } // end of remove()


    /**
     * Returns the minimum value in the list.
     *
     * @return Minimum value in the list.
     *
     * @throws IndexOutOfBoundsException Index is out of bounds.
     */
    public int min() throws IllegalStateException {
        if (mLength == 0) {
            throw new IllegalStateException("Min is not defined for an empty list.");
        }

        // traverse list, looking for the minimum valued element
        int minValue = mHead.getValue();
        Node currNode = mHead.getNext();

        while (currNode != null) {
            if (currNode.getValue() < minValue) {
                minValue = currNode.getValue();
            }
            currNode = currNode.getNext();
        }

        return minValue;
    } // end of min()



    /**
     * Returns the maximum value in the list.
     *
     * @return Maximum value in the list.
     *
     * @throws IndexOutOfBoundsException Index is out of bounds.
     */
    public int max() throws IndexOutOfBoundsException {
        if (mLength == 0) {
            throw new IllegalStateException("Max is not defined for an empty list.");
        }

        // traverse list, looking for the minimum valued element
        int maxValue = mHead.getValue();
        Node currNode = mHead.getNext();

        while (currNode != null) {
            if (currNode.getValue() > maxValue) {
                maxValue = currNode.getValue();
            }
            currNode = currNode.getNext();
        }

        return maxValue;
    } // end of max()


    /**
     * Print the list in head to tail.
     */
    public void print() {
        System.out.println(toString());
    } // end of print()


    /**
     * Print the list from tail to head.
     */
    public void reversePrint() {
    	// IMPLEMENT ME!

    } // end of reversePrint()


    /**
     * @return String representation of the list.
     */
    public String toString() {
        Node currNode = mHead;

        StringBuffer str = new StringBuffer();

        while (currNode != null) {
            str.append(currNode.getValue() + " ");
            currNode = currNode.getNext();
        }

        return str.toString();
    } // end of toString();



    /**
     * Node type, inner private class.
     */
    private class Node
    {
        /** Stored value of node. */
        private int mValue;
        /** Reference to next node. */
        private Node mNext;
        /** Reference to previous node. */
        private Node mPrev;

        public Node(int value) {
            mValue = value;
            mNext = null;
            mPrev = null;
        }

        public int getValue() {
            return mValue;
        }


        public Node getNext() {
            return mNext;
        }


        public Node getPrev() {
            return mPrev;
        }


        public void setValue(int value) {
            mValue = value;
        }


        public void setNext(Node next) {
            mNext = next;
        }

        public void setPrev(Node prev) {
            mPrev = prev;
        }
    } // end of inner class Node

} // end of class DoubleLinkedList
