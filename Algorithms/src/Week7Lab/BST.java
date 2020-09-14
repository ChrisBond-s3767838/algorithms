package Week7Lab;

import java.util.*;


/**
 * Binary search tree implementation.
 *
 * @author Jeffrey Chan, RMIT
 */
public class BST
{
	public static final int EMPTY_TREE = -1;

    /** Root node of the tree. */
	protected Node mRoot;


	public BST() {
		mRoot = null;
	} // end BST()



	/**
     * Add key to tree.
     *
     * @param key Key to insert into BST.
     */
	public void insert(int key) {
		mRoot = insert(mRoot, key);
	} // end of insert()


    /**
     * Recursive method to add key to tree.
     *
     * @param root Root node of tree to add 'key'.
     * @param key Key to add to tree.
     * @return Update root node.
     */
	protected Node insert(Node root, int key) {
		// check if root is empty
		if (root == null) {
			root = new Node(key);
		}
		else if (key < root.mKey) {
			root.mLeftChild = insert(root.mLeftChild, key);
		}
		else if (key > root.mKey) {
			root.mRightChild = insert(root.mRightChild, key);
		}
		else {
			// duplicate value, we do not insert into tree
		}

		return root;
	} // end of insert()



	/**
     * Add key to tree.
     *
     * @param key key to search for.
	 * @return True if key is in the BST, otherwise false.
     */
	public boolean search(int key) {
		
		return search(mRoot,key);
	} // end of search()

	
	protected boolean search(Node root, int key) {

    	if(root==null) {
    		return false;
    	} 
    	else if(key==root.mKey) {
    		return true;
    	}
    	else if (key<root.mKey) { 
    	return 	search(root.mRightChild,key);
		} 
    	else { 	
		  return search(root.mLeftChild,key); 
		 }
		
	} //
	
	
	
	

	/**
     * Inorder traversal of tree.
     */
	public void inorder() {
		inorder(mRoot);
		System.out.println("");
	} // end of inorder()


    /**
     * Inorder traversal of tree.
     *
     * @param root Root node of tree.
     */
	protected void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.mLeftChild);
		// In general, might be better to use a function object here, but for this lab, we just print to stdout
		System.out.print(root.mKey + " ");
		inorder(root.mRightChild);
	} // end of inorder()



    /**
     * Preorder traversal of tree.
     */
	public void preorder() {
		preorder(mRoot);
		System.out.println("");
	} // end of preorder


    /**
     * Preorder traversal of tree.
     *
     * @param root Root node of the tree.
     */
	protected void preorder(Node root) {
		if (root == null) {
			return;
		}

		// In general, might be better to use a function object here, but for this lab, we just print to stdout
		System.out.print(root.mKey + " ");
		preorder(root.mLeftChild);
		preorder(root.mRightChild);
	} // end of preorder


    /**
     * Postorder traversal of tree.
     */
	public void postorder() {
		postorder(mRoot);
		System.out.println("");
	} // end of postorder


    /**
     * Postorder traversal of tree.
     *
     * @param root Root node of the tree.
     */
	protected void postorder(Node root) {
		if (root == null) {
			return;
		}

		postorder(root.mLeftChild);
		postorder(root.mRightChild);
		// In general, might be better to use a function object here, but for this lab, we just print to stdout
		System.out.print(root.mKey + " ");
	} // end of postorder()


    /**
     * Print out tree in ascii text.
     */
    public void asciiPrint() {
        AsciiPrinter.printNode(mRoot);
    } // end of printAscii()


    /**
     * Find minimum key in tree.
     *
     * @return Minimum key in tree.
     */
	public int min() {		
		//get the first element from the inorder
		Node min = getMin(mRoot);
		
		if(min==null) {
			return -1;
		}
		return min.mKey;
	} // end of min()

	
	protected Node getMin(Node root) {
		if (root.mLeftChild == null) {
			return root;
		}

		//System.out.println(root.mKey);
		return getMin(root.mLeftChild);
		
	}

	
	
	

    /**
     * Find maximum key in tree.
     *
     * @return Maximum key in tree.
     */
	public int max() {
		//get the first element from the inorder
		Node max = getMax(mRoot);
		
		if(max==null) {
			return -1;
		}
		return max.mKey;
		
	} // end of max()

	
	
	protected Node getMax(Node root) {
		if (root.mRightChild == null) {
			return root;
		}

		
		return getMax(root.mRightChild);
		
	}
	

    /**
     * Compute the height of the tree.
     *
     * @return Height of tree.
     */
	public int height() {
		return height(mRoot);
	} // end of height()

 // end of class BST





protected int height(Node root)  { 
    if (root == null) {
        return -1; 
    }
    else 
    { 
        /* compute the depth of each subtree */
        int leftDepth = height(root.mLeftChild); 
        int rightDepth = height(root.mRightChild); 
  
        if (leftDepth > rightDepth) 
            return (leftDepth + 1); 
         else 
            return (rightDepth + 1); 
    } 
	}
}




