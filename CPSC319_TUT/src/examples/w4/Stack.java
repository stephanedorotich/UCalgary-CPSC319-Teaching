package examples.w4;

class SNode {
	int data;
	SNode next;

	public SNode(int i) {
		this.data = i;
		this.next = null;
	}
}

public class Stack {
	private SNode top;
	
	public Stack() {
		this.top = null;
	}
	
	public void push(int i) {
		SNode sn = new SNode(i);
		sn.next = top;
		top = sn;
	}
	
	public int pop() {
		int res = -1;
		if (top != null) {
			res = top.data;
			top = top.next;
		}
		return res;
	}
}
