

public class ExpressionTree2
{
	private BinaryNode root;

	private class BinaryNode {
		BinaryNode(String theElement) {
			this( theElement, null, null );
		}

		BinaryNode( String theElement, BinaryNode lt, BinaryNode rt )
		{
			element  = theElement;
			left     = lt;
			right    = rt;
		}

		String element;            // The data in the node
		BinaryNode left;   // Left child
		BinaryNode right;  // Right child
	}

	public ExpressionTree2( )
	{
		root = null;
	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 * @param x the item to insert.
	 */
	public void insert(String x)
	{
		root = insert(x, root);
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * @param x the item to remove.
	 */
	public void remove( String x )
	{
		root = remove(x, root);
	}

	public boolean contains( String x )
	{
		return contains(x, root);
	}

	/**
	 * Test if the tree is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return (root == null);
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree( )
	{
		if( isEmpty( ) )
			System.out.println( "Empty tree" );
		else
			printTree( root );
	}

	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */

	public BinaryNode insert( String x, BinaryNode t) {

		if( t == null ) {
			t = new BinaryNode(x, null, null);
			return t;
			
		}

		if (t.element == "+" || t.element ==  "-" || t.element == "*" || t.element == "/") {
			/*
			if (!(t.left == null)) {
				if (!checkNodeFull(t.left)) {
					if (t.left.element == "+" || t.left.element == "-" || t.left.element == "*" || t.left.element == "/") {
						insert(x, t.left);
					}
				}
				else if (!checkNodeFull(t.right)) {
					if (t.right.element == "+" || t.right.element == "-" || t.right.element == "*" || t.right.element == "/") {
						insert(x, t.right);	
					}
					else {
						t.right = new BinaryNode (x, null, null);
						return t.right;
					}
				}

			}				
			else {
				t.left = new BinaryNode( x, null, null );
				return t.left;
			}
			*/
			
			if (t.left == null) {
				/*t.left = new BinaryNode (x, null, null);
				//return (insert(x, t.left));
				System.out.println(t.left.element);
				return t.left;*/
				System.out.println("The root is now: " + this.root.element + "will be " + x);
				System.out.println(t.left == null);
				return (insert(x, t.left));
			}

		}
		System.out.println("I should be invisible");
		return t;
	}





	/*
			else if (t.right.element == "+" || t.right.element == "-" || t.right.element == "*" || t.right.element == "/") 
				insert(x, t.right);
			else {
				t.right = insert(x, t.right);
				return t.right;
			}
	 */
	//return t;

	public boolean checkNodeFull(BinaryNode bn) {
		if ( !((bn.left == null) && (bn.right == null)) ) {
			if ( !(bn.left.element == "+" || bn.left.element == "-" || bn.left.element == "*" || bn.left.element == "/" ||
					bn.right.element == "+" || bn.right.element == "-" || bn.right.element == "*" || bn.right.element == "-") ) { 
				return true;
			}
		}
		return false;
	}

	public void printLeft() {
		System.out.println(root.left.element);
	}

	public void printRoot() {
		System.out.println("The root is: " + root.element);
	}
	public BinaryNode getRootLeft() {
		return this.root.left;
	}

	public String getElement(BinaryNode nod) {
		return nod.element;
	}

	public BinaryNode getRoot() {
		return this.root;
	}

	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	
	private BinaryNode remove( String x, BinaryNode t )
	{
		if( t == null )
			return t;   // Item not found; do nothing

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			t.left = remove( x, t.left );
		else if( compareResult > 0 )
			t.right = remove( x, t.right );
		else if( t.left != null && t.right != null ) // Two children
		{
			t.element = findMin( t.right ).element;
			t.right = remove( t.element, t.right );
		}
		else
			t = ( t.left != null ) ? t.left : t.right;
		return t;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node containing the smallest item.
	 */
	private BinaryNode findMin( BinaryNode t )
	{
		if( t == null )
			return null;
		else if( t.left == null )
			return t;
		return findMin( t.left );
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node containing the largest item.
	 */
	private BinaryNode findMax( BinaryNode t )
	{
		if( t != null )
			while( t.right != null )
				t = t.right;

		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the subtree.
	 * @return node containing the matched item.
	 */
	private boolean contains( String x, BinaryNode t )
	{
		if( t == null )
			return false;

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			return contains( x, t.left );
		else if( compareResult > 0 )
			return contains( x, t.right );
		else
			return true;    // Match
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * @param t the node that roots the subtree.
	 */
	private void printTree( BinaryNode t )
	{
		if( t != null )
		{
			printTree( t.left );
			System.out.println( t.element );
			printTree( t.right );
		}
	}

	/**
	 * Internal method to compute height of a subtree.
	 * @param t the node that roots the subtree.
	 */
	private int height( BinaryNode t )
	{
		if( t == null )
			return -1;
		else
			return 1 + Math.max( height( t.left ), height( t.right ) );    
	}

	// Basic node stored in unbalanced binary search trees

}