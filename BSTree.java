/** 
 *	Ikbel Amri
 *	Data Structures
 *	Realization of a map by means of a binary search tree.
 *	Adapted by Michael Goodrich
 */

import java.util.Comparator;
import java.util.Iterator;
 
public class BSTree {
	protected BSTNode root; // reference to the root
	protected int size; // number of nodes

	/** Creates an empty binary tree. */
	public BSTree() {
		root = null; // start with an empty tree
		size = 0;
	}

	/** Returns the number of nodes in the tree. */
	public int size() {
		return size;
	}

	/** Returns whether the tree is empty. */
	public boolean isEmpty() {
		return (size == 0);
	}

	/** Returns whether a node is internal. */
	public boolean isInternal(BSTNode v) {
		return (hasLeft(v) || hasRight(v));
	}

	/** Returns whether a node is external. */
	public boolean isExternal(BSTNode v) {
		return !isInternal(v);
	}

	/** Returns whether a node is the root. */
	public boolean isRoot(BSTNode v) {
		return (v == root());
	}

	/** Returns whether a node has a left child. */
	public boolean hasLeft(BSTNode v) {
		return (v.getLeft() != null);
	}

	/** Returns whether a node has a right child. */
	public boolean hasRight(BSTNode v) {
		return (v.getRight() != null);
	}

	/** Returns the root of the tree. */
	public BSTNode root() {
		if (root == null)
			System.out.println("The tree is empty");
		return root;
	}

	/** Returns the left child of a node. */
	public BSTNode left(BSTNode v) {
		BSTNode leftPos = v.getLeft();
		if (leftPos == null)
			System.out.println("No left child");
		return leftPos;
	}

	/** Returns the right child of a node. */
	public BSTNode right(BSTNode v) {
		BSTNode rightPos = v.getRight();
		if (rightPos == null)
			System.out.println("No right child");
		return rightPos;
	}

	/** Returns the parent of a node. */
	public BSTNode parent(BSTNode v) {
		BSTNode parentPos = v.getParent();
		if (parentPos == null)
			System.out.println("No parent");
		return parentPos;
	}

	/** Inserts a left child at a given node. */
	public BSTNode insertLeft(BSTNode v, String e, String k) {
		BSTNode leftPos = v.getLeft();
		if (leftPos != null)
			System.out.println("Node already has a left child");
		BSTNode w = createNode(e, v, null, null, k);
		v.setLeft(w);
		size++;
		return w;
	}

	/** Inserts a right child at a given node. */
	public BSTNode insertRight(BSTNode v, String e, String k) {
		BSTNode rightPos = v.getRight();
		if (rightPos != null)
			System.out.println("Node already has a right child");
		BSTNode w = createNode(e, v, null, null, k);
		v.setRight(w);
		size++;
		return w;
	}

	/** Creates a new binary tree node */
	protected BSTNode createNode(String element, BSTNode parent, BSTNode left, BSTNode right, String key) {
		return new BSTNode(element, parent, left, right, key);
	}

	/**
	 * prints the nodes in the subtree of a node, ordered
	 * according to the inorder traversal of the subtree
	 */
	protected void inorderPrint(BSTNode v) {
		if (hasLeft(v))
			inorderPrint(left(v)); // recurse on left child
		System.out.println(v.key() + ": " + v.element()); 
		// print word then definition of words
		if (hasRight(v))
			inorderPrint(right(v)); // recurse on right child
	} 	
	
	// auxiliary helper method that serves to recursively add the node to
	// the binary search tree in an alphabetical way
	public void insertHelper(BSTNode v, BSTNode newNode) {
		if (newNode.key.compareTo(v.key)>0) {
		// if the new word comes after the v node alphabetically
			if (hasRight(v)) // if v has a right child
				insertHelper(v.getRight(), newNode); 
				// recursively run the method on the tree whose root is the right child of v
			else 
				insertRight(v, newNode.element(), newNode.key());
				// insert the newNode to the right of v
		}
		else if (newNode.key.compareTo(v.key)<0) {
		// if the new word comes before the v node alphabetically
			if (hasLeft(v)) // if v has a left child
				insertHelper(v.getLeft(), newNode);
				// recursively run the method on the tree whose root is the left child of v
			else
				insertLeft(v, newNode.element(), newNode.key());
				// insert the newNode to the left of v
		}
		else { // if the new word is the same as the word it is being compared to
			v.setElement(newNode.element());
			// redefine the node so it contains the new definition of the word if different
		}
	}
	
	// method serves to insert a new node (element value) into binary search tree
	// that represents the dictonary
	public void insert (String word, String def) {
		BSTNode newNode = new BSTNode (def, null, null, null, word);
		if (isEmpty()) { // if the tree is empty which means the root is set to null
			root = newNode;
		}
		else {
			insertHelper(root, newNode); 
			// run the insert helper auxiliary method and assign the node it returns to a temporary element
		}
		size ++;
	}
	
	/**
	 * Auxiliary helper method that searches for words recursively
	*/
	public void searchHelper (BSTNode v, String word) {
		if (word.compareTo(v.key)>0) {
		// if the new word comes after the v node alphabetically
			if (hasRight(v)) // if v has a right child
				searchHelper(v.getRight(), word); 
				// recursively run the method on the tree whose root is the right child of v
			else 
				System.out.println("No definition for '" + word + "' found ");
		}
		else if (word.compareTo(v.key)<0) {
		// if the new word comes before the v node alphabetically
			if (hasLeft(v)) // if v has a left child
				searchHelper(v.getLeft(), word);
				// recursively run the method on the tree whose root is the left child of v
			else 
				System.out.println("No definition for '" + word + "' found ");
		}
		else { // if the new word is the same as the word it is being compared to
				System.out.println(word + ": " + v.element()); // found it
		}
	}
	
	// search for a word within the dictionary
	public void search (String word) {
		if (isEmpty()) 
		// if root is set to null, so that tree is empty and no words have been stored
			System.out.println("The dictionary is empty.");
		else // if tree contains any elements 
			searchHelper(root, word); // run it for the rest of the tree
	}
	
	// print dictionary items having recourse to the inorder method
	public void printEntries(){
		if (isEmpty()) 
		// if root is set to null, so that tree is empty and no words have been stored
			System.out.println("The dictionary is empty.");
		else 
			inorderPrint(root); // run the auxiliary helper method inorderPrint
	}
	
	// Removes a node with zero or one child. 	
	public void removeH(BSTNode v) {
		BSTNode leftPos = v.getLeft();
		BSTNode rightPos = v.getRight();
		BSTNode w; // the only child of v, if any
		if (leftPos != null)
			w = leftPos;
		else if (rightPos != null)
			w = rightPos;
		else
			// v is a leaf
			w = null;
		if (v == root) { // v is the root
			if (w != null)
				w.setParent(null);
			root = w;
		} else { // v is not the root
			BSTNode u = v.getParent();
			if (v == u.getLeft())
				u.setLeft(w);
			else
				u.setRight(w);
			if (w != null)
				w.setParent(u);
		}
		size--;
	}
	
	// return the smallest word alphabetically
	public BSTNode smallestWord(BSTNode v) {
		BSTNode leftPos = v.getLeft(); // get the left node of v
		if (v.getLeft() == null) // if node has no left child
								 // since this is a binary search tree
			return v; // found it
		else
			return smallestWord(leftPos); // run recursively with left node
	}
	
	// searchRemove function to locate the position to be removed and communicate with the user
	public void remove(BSTNode v, String word){
		if (word.compareTo(v.key)>0)  {
			// System.out.println("bigger");
			if (hasRight(v)) {// if v has a right child 
				// System.out.println("has right");
				remove(v.getRight(), word); 
				 }
			else 
				System.out.println("Could not find word entry '" + word + "' in the dictionary");
		}
		else if (word.compareTo(v.key)<0) {
			if (hasLeft(v)) { // if v has a left child 
				remove(v.getLeft(), word);
				}
			else 
				System.out.println("Could not find word entry '" + word + "' in the dictionary");
		}
		else { // if the new word is the same as the word it is being compared to
			BSTNode leftPos = v.getLeft(); // get the left node of v
			BSTNode rightPos = v.getRight(); // get the right node of v
			if (leftPos != null && rightPos != null) {
			// if the node to be removed has two children
				BSTNode smallestNode = smallestWord(rightPos);
				// find the smallest word alphabetically in the right subtree
				v.key = smallestNode.key();
				v.element = smallestNode.element();
				// swap the value of the node to be removed with the smallest found in right subtree
				removeH(smallestNode);
				// remove the smallest word from its original spot 
				// since we have swapped its position and it's duplicated
			}
			else { // if the node to be removed has only one child or no children at all
				removeH(v); // remove it
			}
			System.out.println("The word entry '" + word + "' was removed from the dictionary ");
		}
	}
	
	// initial remove method that uses recursive remove method to remove an entry
	public void removeEntry(String word){
		if (isEmpty()) 
		// if root is set to null, so that tree is empty and no words have been stored
			System.out.println("The dictionary is empty.");
		else // if tree contains any elements 
			remove(root, word); // run it for the rest of the tree
	}
}