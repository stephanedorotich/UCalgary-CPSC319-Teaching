package examples.w4;

class QNode {
	int data;
	QNode next;
	
	public QNode(int i) {
		this.data = i;
		this.next = null;
	}
}

public class Queue {
	QNode front;
	QNode back;
	
	public Queue() {
		this.front = null;
		this.back = null;
	}
	
	public void pushBack() {
		
	}
	
	public int popFront() {
		int res = -1;
		if (front != null) {
			res = front.data;
			front = front.next;
		}
		return res;
	}
}
