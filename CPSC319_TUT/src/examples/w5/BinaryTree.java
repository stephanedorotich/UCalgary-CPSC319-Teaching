package examples.w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
	int data;
	Node left;
	Node right;
	
	Node (int i) {
		data = i;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	private Node root;
	
	BinaryTree() {
		root = null;
	}

	
	public void insert(int i) {
		if (root == null) root = new Node(i);
		else insert_node(i, root);
	}
	
	private void insert_node(int i, Node parent) {
		if (i > parent.data) {
			if (parent.right == null) parent.right = new Node(i);
			else insert_node(i, parent.right);
		} else {
			if (parent.left == null) parent.left = new Node(i);
			else insert_node(i, parent.left);
		}
	}

	
	public void display() {
		display_node(0, root);
	}
	
	private void display_node(int depth, Node n)
	// In-order display of BinaryTree
	{
		// Recursively print out left side of tree
		if (n.left != null) display_node(depth+1, n.left);
		
		// Print 'depth' tab characters + node data
		for (int i = 0; i < depth; i++)	System.out.print("\t");
		System.out.println(n.data);

		// Recursively print out right side of tree
		if (n.right != null) display_node(depth+1, n.right);
	}
	
		
	public static void main(String[] args) {
		// Create new BinaryTree object	
		BinaryTree myBTree = new BinaryTree();	
		
		// Create reader for user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		// Ask user to input numbers to insert into the BinaryTree
		while (true) {
			try {
				System.out.print("Enter a number: ");
				i = Integer.parseInt(br.readLine());
				myBTree.insert(i);
				continue;
			} catch (Exception e) {
				break; // if input cannot be parsed as an integer
			}
		}
		myBTree.display();
	}
}
