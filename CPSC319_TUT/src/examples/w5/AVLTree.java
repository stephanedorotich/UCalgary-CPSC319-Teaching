package examples.w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AVLTree {
	private class Node {
		int key;
		Node left;
		Node right;
		
		int height;
		
		public Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}
	}

	Node root;
		
	public AVLTree() {
		root = null;
	}
	public void insertNode(int key) {
		root = insertNode(key, root);
	}
	
	public Node insertNode(int key, Node node) throws IllegalArgumentException {
		// No node at current position, store new node at current position
		if (node == null) {
			node = new Node(key);
		}
		
		// Otherwise, traverse the tree to the left or right depending on the key
		else if (key < node.key) {
			node.left = insertNode(key, node.left);
		} else if (key > node.key) {
			node.right = insertNode(key, node.right);
		} else {
			throw new IllegalArgumentException("BST already contains a node with key " + key);
		}
		
		updateHeight(node);
		return rebalance(node);	
	}
	
	private Node rebalance(Node node)
	// TODO
	{
		int balanceFactor = balanceFactor(node);
		return node;
	}
	
	private int balanceFactor(Node node) {
		return height(node.right) - height(node.left);
	}
	

	private Node rotateRight(Node node)
	// TODO
	{
		return node;
	}
	
	private Node rotateLeft(Node node)
	// TODO
	{
		return node;
	}
	
	private int height(Node n) {
		if (n == null) return -1;
		else return n.height;
	}
	
	private void updateHeight(Node node) {
		int leftChildHeight = height(node.left);
		int rightChildHeight = height(node.right);
		node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
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
		System.out.println(n.key);

		// Recursively print out right side of tree
		if (n.right != null) display_node(depth+1, n.right);
	}
	
	public static void main(String[] args) {
		// Create new AVLTree	
		AVLTree myTree = new AVLTree();	
		
		// Create reader for user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		// Ask user to input numbers to insert into the BinaryTree
		while (true) {
			try {
				System.out.print("Enter a number: ");
				i = Integer.parseInt(br.readLine());
				myTree.insertNode(i);
				continue;
			} catch (Exception e) {
				break; // if input cannot be parsed as an integer
			}
		}
		myTree.display();
	}	
}
