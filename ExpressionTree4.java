import java.util.ArrayList;


public class ExpressionTree4 {
	private BinaryNode root;
	public static String expression = "";
	//creates an empty tree
	public ExpressionTree4( ) {
		root = null;
	}
	
	//basic initialization
	class BinaryNode {		
		String element;		// The data in the node
		BinaryNode left;	// Left child
		BinaryNode right;	// Right child

		BinaryNode (String theElement) {
			this.element = theElement;
		}

		BinaryNode(String anElement, BinaryNode lt, BinaryNode rt) {
	
			this.element  = anElement;
			this.left     = lt;
			this.right    = rt;
		}


	}
	
	//when called from the main
	public void insert(String x) {
		root = insert(x, root);
	}
	
	//actual tree construction
	public BinaryNode insert( String x, BinaryNode t) {
		//inserts values into null spots
		if( t == null ) {
			t = new BinaryNode(x, null, null);
			System.out.println("Added: " + t.element);
			return t;
		}
		//starting from the left, it checks to see if a node is an operand or an operator. It keeps going until it gets
		//an operand, and then it fills that operator's nodes out. If the nodes are already full, then it goes to the right node
		//of the current operator and fills it out.
		if (t.element == "+" || t.element ==  "-" || t.element == "*" || t.element == "/") {
			//if the left is empty, it simply inserts it there
			if (t.left == null) {
				t.left = insert(x,  t.left);
				return t;
			}
			//if it's an operator, and it's not already full, then it inserts into the left first, then the right.
			if (t.left.element == "+" || t.left.element == "-" || t.left.element == "*" || t.left.element == "/") {
				if(!checkNodeFull(t.left)) {
					t.left = insert(x,  t.left);
					return t;
				}
				else {
					t.right = insert(x, t.right);
					return t;
				}
			}
			//if the left has a number then the right gets filled if it's empty
			else if (t.right == null) {
				t.right = insert(x, t.right);
				return t;
			}
			//if the right is an operator then it also gets filled from left to right
			else if (t.right.element == "+" || t.right.element == "-" || t.right.element == "*" || t.right.element == "/") {
				t.right = insert(x, t.right);
				return t;
			}
		}
		return t;
	}

	public void printPreFix() {
		BinaryNode node = this.root;

	}
	
	//goes through every single node connected to a given node and makes sure that every single operator has two operands.
	//if it is all "full," it returns true.
	public boolean checkNodeFull(BinaryNode bn) {
		if (bn == null || bn.left == null || bn.right == null) {
			return false;
		}
		else if ( !(bn.left.element == "+" || bn.left.element == "-" || bn.left.element == "*" || bn.left.element == "/" ||
				bn.right.element == "+" || bn.right.element == "-" || bn.right.element == "*" || bn.right.element == "/") ) { 
			return true;
		}

		else if (bn.left.element == "+" || bn.left.element == "-" || bn.left.element == "*" || bn.left.element == "/") {
			return checkNodeFull(bn.left);
		}
		else if (bn.right.element == "+" || bn.right.element == "-" || bn.right.element == "*" || bn.right.element == "/") {
			return checkNodeFull(bn.right);
		}
		return false;
	}

	//clears the "expression" string, then fills it out
	public void printPrefix( ) {
		expression = "";
		printPrefix( root );
		System.out.println(expression);
	}
	
	//concatenates all the nodes in prefix order. Starts from the very far left and works its way back. Similar to the "findMin" method.
	private void printPrefix(BinaryNode t)  {
		if( t != null ) {
			expression += t.element;
			printPrefix( t.left );
			printPrefix( t.right );
		}
	}
	
	public void printInfix( ) {
		expression = "";
		printInfix( root );
		System.out.println(expression);
	}
	//Prints the leftmost expression after the appropriate number of recurses. If it hits a number, the "if" statement
	//bounces it back and it adds the number to "expression".
	private void printInfix(BinaryNode t)  {
		if( t != null ) {
			expression = expression + "(";
			printInfix( t.left );
			expression = expression + t.element;
			printInfix( t.right );
			expression = expression + ")";
		}
	}

	public int evaluate() {
		return getValue(root);
	}
	
	//the getValue method goes to the far leftmost side of the tree and then works its way up and to the right.
	//the "total" value is added to itself recursively. 
	private int getValue(BinaryNode t) {
		int total = 0;
		if (t.left == null) {
			total = Integer.parseInt(t.element);
		}
		else {
			int left, right;

			left = getValue(t.left);
			right = getValue(t.right);

			if(t.element == "+") {
				total = left + right;
				return total;
			}
			if(t.element == "-") {
				total = left - right;
				return total;
			}
			if(t.element == "*") {
				total = left * right;
				return total;
			}
			if(t.element == "/") {
				total = left / right;
				return total;
			}
		}
		return total;
	}

		public void printLeft() {
			System.out.println(root.left.left.element);
		}

		public void printRight() {
			System.out.println(root.right.left == null);
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
	}