package examples.w3;

class Node {
	private int data;
	private Node next;
	
	public Node(int data)
	// Constructor
	{
	}
	
	public int getData() {
		return 0;
	}
	
	public Node getNextNode()
	// Returns the next node in the linked list
	{
		return null;
	}
	
	public void setNextNode(Node next)
	// Sets the next node in the linked list
	{
	}
	
	public void print()
	// Prints this nodes data value
	{
		System.out.printf("%d  -->  ", this.data);
	}
}


public class LinkedList {
	private Node head;
	
	public LinkedList()
	// Constructor
	{
		return;
	}
	
	public void insertHead(int val)
	// Inserts a new node at the beginning of the Linked List
	{
		return;
	}
	
	public void insertTail(int val)
	// Inserts a new node at the end of the Linked List
	{
		return;
	}
	
	public void delete(int val)
	// Delete the first node whose data is equal to val
	{
		// case 1: list is empty
		
		// case 2: delete head
		
		// case 3: check other nodes
		// case 3a: value not found
		// case 3b: value found, was tail
		// case 3c: value found
		return;
	}
	
	public void display()
	//	Prints out the data of all Nodes in the Linked List
	{
		return;
	}
}
