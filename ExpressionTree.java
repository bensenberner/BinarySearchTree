
public class ExpressionTree<T extends Comparable<? super T>>{
	private Node<T> root;

	public ExpressionTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(T value) {
		return contains(value, root);
	}

	private boolean contains(T x, Node<T> t) {
		if (t == null) {
			return false;
		}
		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			return contains(x, t.left);
		}
		else if(compareResult > 0) {
			return contains(x, t.right);
		}
		else {
			return true;
		}	
	}
	/*	
	public T findMin() {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return findMin(root).element;
	}
	 */	
	private static class Node<T>{
		T element;
		Node<T> left;
		Node<T> right;

		Node(T theElement) {
			this(theElement, null, null);
		}

		Node(T theElement, Node<T> operand1, Node<T> operand2) {
			element = theElement;
			left = operand1;
			right = operand2;
		}
	}
}