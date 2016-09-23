/** 
 *	Ikbel Amri
 *	Data Structures
 *	Realization of a map by means of a binary search tree.
 *	Adapted by Michael Goodrich
 */
  
public class BSTNode {

	protected String element;  	// String element stored by a node
	protected String key; // String key stored by a node
	protected BSTNode left, right, parent; // Pointers to adjacent nodes nodes

	/** Constructor that creates a node with given fields */
	public BSTNode(String element, BSTNode parent, BSTNode left, BSTNode right, String key) {
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRight(right);
		setKey(key);
	}

	/** Returns the element of this node */
	public String  element() {  return element; }

	/** Returns the left node of this node */
	public BSTNode getLeft() {  return left; }

	/** Returns the right node of this node */
	public BSTNode getRight() {  return right; }
	
	/** Returns the parent node of this node */
	public BSTNode getParent() { return parent; }
	
	/** Returns the key node of this node */
	public String key() { return key; }
	
	/** Sets the element of this node */
	public void setElement(String newElem) { element = newElem; }
	
	/** Sets the left node of this node */
	public void setLeft(BSTNode newLeft) { left = newLeft; }
	
	/** Sets the right node of this node */
	public void setRight(BSTNode newRight) { right = newRight; }
	
	/** Sets the parent node of this node */
	public void setParent(BSTNode newParent) { parent = newParent; }
	
	/** Sets the key node of this node */
	public void setKey(String newKey) { key = newKey; }
	
	}