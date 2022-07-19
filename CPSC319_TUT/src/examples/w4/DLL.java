package examples.w4;

class Node {
	int data;
	Node prev;
	Node next;
	
	public Node(int i) {
		this.data = i;
		this.prev = null;
		this.next = null;
	}
}

public class DLL
{
	private Node head;
	private int length;
	
	public DLL()
	// Constructor
	{
		this.head = null;
		this.length = 0;
	}
	
	public void insert(int i)
	// Perform a sorted insert of a new Node(i) into the list
	{
		
	}
	
	public boolean remove(int i)
	// Remove the first node whose data == i
	// returns true if a node was removed, false otherwise
	{
		return true;
	}
	
	public void display()
	// Prints the contents of the list
	{
		
	}
	
	public int length() {
		return this.length;
	}
	
	public Node head() {
		return this.head;
	}
}
