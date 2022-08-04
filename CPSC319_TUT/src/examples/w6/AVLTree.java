package examples.w6;

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
	
	public void deleteNode(int key) {
		root = deleteNode(key, root);	
	}
	
	public Node deleteNode(int key, Node node) {
		// key can't be found in the tree
		if (node == null) return null;
		
		if (key < node.key) node.left = deleteNode(key, node.left);
		else if (key > node.key) node.right = deleteNode(key, node.right); 
		else  {
			boolean lchild = (node.left != null); // true if there is a left child
			boolean rchild = (node.right != null); // true if there is right child
			
			// Case 1: no children
			if (!lchild && !rchild) {
				return null;
			}
			// Case 2: left child only
			if (lchild && !rchild) {
				return node.left;
			}
			// Case 3: right child only
			if (!lchild && rchild) {
				return node.right;
			}
			// Case 4: both children
			if (lchild && rchild)  {
				// get valid successor
				Node temp = getSmallestNode(node.right);
				// remove successor from right subtree
				node.right = deleteNode(temp.key, node.right);
				
				temp.right = node.right; // successor adopts right subtree
				temp.left = node.left; // successor adopts left subtree
				node = temp; // replace node with successor
			}
		}
		updateHeight(node);
		return rebalance(node);
	}
	
	private Node getSmallestNode(Node node) {
		Node temp = node;
		while (temp.left != null) temp = temp.left;
		return temp;
	}
		
	private Node rebalance(Node node)
	{
		// left left heavy
		if (balanceFactor(node) < -1 && balanceFactor(node.left) <= 0) {
			node = rotateRight(node);			
		}
		// left right heavy
		else if (balanceFactor(node) < -1 && balanceFactor(node.left) > 0) {
			node.left = rotateLeft(node.left);
			node = rotateRight(node);
		}
		// right left heavy
		else if (balanceFactor(node) > 1 && balanceFactor(node.right) < 0) {
			node.right = rotateRight(node.right);
			node = rotateLeft(node);
		}
		// right right heavy		
		else if (balanceFactor(node) > 1 && balanceFactor(node.right) >= 0) {
			node = rotateLeft(node);
		}
		return node;
	}
	
	private int balanceFactor(Node node) {
		return height(node.right) - height(node.left);
	}
	

	private Node rotateRight(Node node)
	{
		Node leftChild = node.left;
		
		node.left = leftChild.right;
		leftChild.right = node;
		
		updateHeight(node);
		updateHeight(leftChild);
		return leftChild;
	}
	
	private Node rotateLeft(Node node)
	{
		Node rightChild = node.right;
		
		node.right = rightChild.left;
		rightChild.left = node;
		
		updateHeight(node);
		updateHeight(rightChild);
		return rightChild;
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
	
	private static void usage() {
		System.out.println("Usage:");
		System.out.println("\tI x\t\tto insert x");
		System.out.println("\tD x\t\tto delete x");
		System.out.println("\tDisplay\t\tto display the tree");
		System.out.println("\tExit\t\tto Exit the program");
	}
	
	
	
	
	public static void main(String[] args) {
		// Create new AVLTree	
		AVLTree myTree = new AVLTree();	
		
		// Create reader for user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		
		usage();
		String input;
		while (true) {
			try {
				input = br.readLine();
				if (input.compareTo("Exit") == 0) break;
				else if (input.compareTo("Display") == 0) myTree.display();
				else if (input.charAt(0) == 'I') {
					i = Integer.parseInt(input.substring(2));
					myTree.insertNode(i);
				}
				else if (input.charAt(0) == 'D') {
					i = Integer.parseInt(input.substring(2));
					myTree.deleteNode(i);			
				}
				else usage();
			} catch (Exception e) {
				usage(); // if input cannot be parsed as an integer
			}
		}
	}	
}
