import java.util.Scanner;

/*
Name: Benjamin Lerner
UNI: bll2121
 */

public class TestingTesting {
	public static void main(String[] args) {
		ExpressionTree4 arbor = new ExpressionTree4();
		MyStack stacked = new MyStack();
		Scanner readin = new Scanner(System.in);
		System.out.println("Please hardcode in a prefix expression.");
		/*
		int counter = 0;
		String input = readin.nextLine();
		while(!(input.equals("done"))) {
			stacked.push(input);
			input = readin.nextLine();
			++counter;
		}
		for (int i = 0; i < counter; ++i) {
			arbor.insert(stacked.pop().toString());
		}
		*/
		arbor.insert("*");
		arbor.insert("+");
		arbor.insert("3");
		arbor.insert("5");
		arbor.insert("*");
		arbor.insert("2");
		arbor.insert("+");
		arbor.insert("4");
		arbor.insert("8");
		
		System.out.println("Prefix expression: ");
		arbor.printPrefix();
		System.out.println("Infix expression: ");
		arbor.printInfix();
		System.out.println("Value of tree: " + arbor.evaluate());
	}
}
//NumberFormatException