package examples.w4;

import examples.w2.ListCreator;
import examples.w2.InsertionSort;

public class DLL_Tester {

	static boolean testRemove()
	// Testing remove.
	{
		int totalTests = 7;
		int numPassedTests = totalTests;
		
		// Test 1 -- insert 1 elem, remove same elem
		DLL l1 = new DLL();
		l1.insert(1);
		l1.remove(1);
		if (l1.head() != null & l1.length() == 0) {
			System.out.println("REMOVE:\t\tDid not reset head to null OR set length to 0 after removing last element.");
			numPassedTests--;
		}
		
		// Test 2 -- removing an element from an empty list
		DLL l2 = new DLL();
		l2.remove(7);
		if (l2.remove(7) || l2.length() != 0) {
			System.out.println("REMOVE:\t\tDid not return false when trying to remove a node from an empty list OR adjusted the size.");
			numPassedTests--;
		}
		
		// Test 3 -- removing an element that is not in a non-empty list
		for (int i = 0; i < 10; i++) {
			l2.insert(i);
		}
		if (l2.remove(13) || l2.length() != 10) {
			System.out.println("REMOVE:\t\tDid not return false when trying to remove a node that is not in the list OR adjusted the size.");
			numPassedTests--;
		}
		
		// Test 4 -- Removing the first element
		l2.remove(0);
		Node n = l2.head();
		int cmp = 1;
		while (n != null) {
			if (n.data != cmp) break;
			cmp++;
			n = n.next;			
		}
		if (cmp != 10) {
			System.out.println("REMOVE:\t\tDid not properly remove the first node from the list.");
			numPassedTests--;
		}
		
		// Test 5 -- Removing the last element
		l2.remove(9);
		n = l2.head();
		cmp = 1;
		while (n != null) {
			if (n.data != cmp) break;
			cmp++;
			n = n.next;			
		}
		if (cmp != 9) {
			System.out.println("REMOVE:\t\tDid not properly remove the last node from the list.");
			numPassedTests--;
		}
		
		// Test 6 -- Removing an element from the middle
		int val = 5;
		l2.remove(val);
		n = l2.head();
		Node temp = null;
		cmp = 1;
		while (n != null) {
			if (cmp == val) {
				cmp++;
				continue;
			}
			if (n.data != cmp) break;
			cmp++;
			if (n.next == null) temp = n;
			n = n.next;
		}
		if (cmp != 9) {
			System.out.printf("REMOVE:\t\tDid not properly remove node<%d> from the list.\n", val);
			numPassedTests--;
		}
		
		// Test 7 -- checking the prev pointers
		cmp = 8;
		while (temp != null) {
			if (cmp == val) {
				cmp--;
				continue;
			}
			if (temp.data != cmp) break;
			cmp--;
			temp = temp.prev;
		}
		if (cmp != 0) {
			System.out.println("REMOVE:\t\tDid not properly update prev pointers on removal");
			numPassedTests--;			
		}

		System.out.printf("...Passed %d/%d REMOVE tests.\n\n", numPassedTests, totalTests);
		return (totalTests == numPassedTests);
	}
	
	
	
	
	static boolean testInsert()
	// Testing insert.
	{
		int totalTests = 4;
		int numPassedTests = totalTests;
		
		// Insert test 1
		DLL myDLL = new DLL();
		myDLL.insert(0);
		if (myDLL.head() == null || myDLL.head().data != 0) {
			System.out.println("INSERT:\t\tDid not properly insert a the first node");
			numPassedTests--;
		}
		
		// Insert test 2 -- ordered insert
		for (int i = 1; i < 10; i++) {
			myDLL.insert(i);
		}
		Node n = myDLL.head();
		int cmp = 0;
		while (n != null) {
			if (n.data != cmp) break;
			cmp++;
			n = n.next;
		}
		if (cmp != 10) {
			System.out.println("INSERT:\t\tDid not properly insert numbers [0, 1, ..., 9]");
			numPassedTests--;
		}
		
		// Insert test 3 -- reverse insert
		DLL l1 = new DLL();
		for (int i = 10; i > 0; i--) {
			l1.insert(i);
		}
		n = l1.head();
		cmp = 1;
		while (n != null) {
			if (n.data != cmp) break;
			cmp++;
			n = n.next;
		}
		if (cmp != 11) {
			System.out.println("INSERT:\t\tDid not properly insert numbers [10, 9, ..., 1]");
			numPassedTests--;
		}
		
		// Insert test 4 -- random insert
		DLL l2 = new DLL();
		int x = 100;
		int[] nums = ListCreator.rand_nums(x, 1000); // x nums from [0, 1000)
		for (int i = 0; i < x; i++) {
			l2.insert(nums[i]);
		}
		InsertionSort.insertionSort(nums);
		n = l2.head();
		cmp = 0;
		while (n != null) {
			if (n.data != nums[cmp]) break;
			cmp++;
			n = n.next;
		}
		if (cmp != x) {
			System.out.printf("INSERT:\t\tDid not properly insert a list of %d random numbers.\n", x);
			numPassedTests--;
		}
		

		System.out.printf("...Passed %d/%d INSERT tests.\n\n", numPassedTests, totalTests);
		return (totalTests == numPassedTests);
	}
	
	
	
	
	static boolean testLength()
	// Testing length.
	{
		int totalTests = 2;
		int numPassedTests = totalTests;
		DLL myDLL = new DLL();
		
		
		// Length test 1 -- insert 10 elem
		for (int i = 0; i < 10; i++) {
			myDLL.insert(i);
		}
		if (myDLL.length() != 10) {
			System.out.println("LENGTH:\t\tDid not increase length by 1 after each insertion");
			numPassedTests--;
		}
		
		// Length test 2 -- remove 5 elem
		for (int i = 0; i < 5; i++) {
			myDLL.remove(i);
		}
		if (myDLL.length() != 5) {
			System.out.println("LENGTH:\t\tDid not decrease length by 1 afer each removal");
			numPassedTests--;
		}

		
		System.out.printf("...Passed %d/%d LENGTH tests.\n\n", numPassedTests, totalTests);
		return (totalTests == numPassedTests);
	}
	
	
	public static void runTests() {
		if (testLength() & testInsert() & testRemove()) {
			System.out.println("All tests passed :)");
		}
	}
	
	public static void main(String[] args) {
		runTests();
		
//		DLL list = new DLL();
//		list.insert(1);
//		list.insert(2);
//		
//		list.display();
//		
//		list.remove(1);
//		list.display();
		
//		DLL list = new DLL();
//		...
//		list.display();
	}
	
	
}
