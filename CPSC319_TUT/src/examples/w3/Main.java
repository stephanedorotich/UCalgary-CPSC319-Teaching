package examples.w3;

public class Main {

	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
		
		for (int i = 0; i < 10; i++) {
			LL.insertHead(i);
//			LL.insertTail(i);
		}
		LL.display();
	}
}
