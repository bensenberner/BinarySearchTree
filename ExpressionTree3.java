
public class ExpressionTree3
{
	private BinaryNode root;

	public ExpressionTree3( ) {
		root = null;
	}


	public enum NodeFlavor {
		OPERAND,
		OPERATOR
	}

	class BinaryNode {		
		NodeFlavor type;	// the kind of node
		String element;		// The data in the node
		BinaryNode left;	// Left child
		BinaryNode right;	// Right child

		BinaryNode (String theElement) {
			this.type = NodeFlavor.OPERAND;
			this.element = theElement;
		}

		BinaryNode(String anElement, BinaryNode lt, BinaryNode rt)
		{
			this.type = NodeFlavor.OPERATOR;
			this.element  = anElement;
			this.left     = lt;
			this.right    = rt;
		}


	}

	public void insert(String x) {
		root = insert(x, root);
	}

	public BinaryNode insert( String x, BinaryNode t) {
		if( t == null ) {
			t = new BinaryNode(x, null, null);
			System.out.println("gonna add " + t.element);
			return t;
		}

		if (t.element == "+" || t.element ==  "-" || t.element == "*" || t.element == "/") {
			/*
			if (!(t.left == null)) {
				if (!checkNodeFull(t.left)) {
					if (t.left.element == "+" || t.left.element == "-" || t.left.element == "*" || t.left.element == "/") {
						t.left = insert(x, t.left);
						return t;
					}
				}
				else if (!checkNodeFull(t.right)) {
					if (t.right.element == "+" || t.right.element == "-" || t.right.element == "*" || t.right.element == "/") {
						t.right = insert(x, t.right);
						return t;

					}
					else {
						t.right = new BinaryNode (x, null, null);
						return t;
					}
				}
				else {

				}
			}	

			else {
				t.left = insert(x, t.left);
				return t;
			}
			 */

			if (t.left == null) {
				t.left = insert(x, t.left);
				return t;
			}


			if (t.left.element == "+" || t.left.element == "-" || t.left.element == "*" || t.left.element == "/") {
				//if (!(checkNodeFull(t.left))) {
				/*
				if (t.left.left == null) {
					t.left.left = insert(x, t.left.left);
					return t;
				}
				else if (t.left.left.element == "+" || t.left.left.element == "-" || t.left.left.element == "*" || t.left.left.element == "/") {
					t.left.left = insert(x, t.left.left);
				}
				else {
					t.right.right = insert(x, t.right.right);
					return t;
				}
				 */
				//}
				t.left = insert(x,  t.left);
				return t;
			}

			else if (t.right.element == "+" || t.right.element == "-" || t.right.element == "*" || t.right.element == "/") {
				t.right = insert(x,  t.right);
				return t;
			}

			else {
				t.right = insert(x, t.right);
				return t;
			}
			//				else if (t.right.element == "+" || t.right.element == "-" || t.right.element == "*" || t.right.element == "/") {
			//					t.right = insert(x, t.right);
			//					return t;
			//				}

		}
		System.out.println("I should be invisible");
		return t;
	}


	public boolean checkNodeFull(BinaryNode bn) {
		if ( !((bn.left == null) || (bn.right == null)) ) {
			
			if ( !(bn.left.element == "+" || bn.left.element == "-" || bn.left.element == "*" || bn.left.element == "/" ||
					bn.right.element == "+" || bn.right.element == "-" || bn.right.element == "*" || bn.right.element == "-") ) { 
				return true;
			}
			 
		}
		return false;
	}

	public void printLeft() {
		System.out.println(root.left.left.element);
	}

	public void printRight() {
		System.out.println(root.right.right.element);
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



	/*
	static int getValue (BinaryNode node) {
		if (node.type == NodeFlavor.OPERAND){
			return Integer.parseInt(node.element);
		}
		else {
			int leftNum = getValue(node.left);
			int rightNum = getValue(node.right);

		}
	}
	 */

	/**
	 * Insert into the tree; duplicates are ignored.
	 * @param x the item to insert.
	 */


	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * @param x the item to remove.
	 */
	/*
	public void remove( String x )
	{
		root = remove(x, root);
	}
	 */

	public boolean isEmpty( )
	{
		return (root == null);
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	/*
	public void printTree( )
	{
		if( isEmpty( ) )
			System.out.println( "Empty tree" );
		else
			printTree( root );
	}
	 */
	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */

	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	/*
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
	 */
	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node containing the smallest item.
	 */

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the subtree.
	 * @return node containing the matched item.
	 */


	// Basic node stored in unbalanced binary search trees

}