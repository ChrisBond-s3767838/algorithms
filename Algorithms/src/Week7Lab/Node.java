package Week7Lab;

import Week7Lab.BST;

/**
 * Inner class implementation of a node.
 *
 * @author Jeffrey Chan
 */
class Node
{
        /** For this lab, we only store ints, but in general we can store any object/type that is Comparable. */
        public int mKey;
        /** Reference to left child. */
        public Node mLeftChild;
        /** Reference to right child. */
        public Node mRightChild;


        /**
         * Constructor.
         *
         * @param key Key to store in node.
         */
        public Node(int key) {
                mKey = key;
                mLeftChild = null;
                mRightChild = null;
        }


        /**
         *
         * @return Key stored in node.
         */
        public int key() {
            return mKey;
        } // end of getKey()


        /**
         *
         * @return Reference to left child of node.
         */
        public Node leftChild() {
            return mLeftChild;
        } // end of leftChild()


        /**
         *
         * @return Reference to right child of node.
         */
        public Node rightChild() {
            return mRightChild;
        } // end of rightChild()

} // end of class Node