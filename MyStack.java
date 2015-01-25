import java.util.ArrayList;


public class MyStack<AnyType>{
	private ArrayList<AnyType> theArray = new ArrayList<AnyType>();
	private int topOfStack;

	public MyStack () {
		topOfStack = -1;
	}

	public void push(AnyType x) {
		topOfStack++;
		theArray.add(x);
	}

	public AnyType pop() {
		AnyType popper = theArray.get(topOfStack);
		topOfStack--;
		return popper;
	}
}
