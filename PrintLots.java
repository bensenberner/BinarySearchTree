import java.util.*;


public class PrintLots {
	public static void main(String[] args) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		LinkedList<Integer> P = new LinkedList<Integer>();
		L.addAll(Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 121, 244, 1024));
		P.addAll(Arrays.asList(2, 3, 5, 8));
		for (int i = 0; i < P.size(); ++i) {
			System.out.println(L.get(P.get(i)));		
		}
	}
}
