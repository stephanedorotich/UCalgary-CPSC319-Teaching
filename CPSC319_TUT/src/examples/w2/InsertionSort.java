package examples.w2;

import java.util.Random;

class ListCreator {
	int[] rand_nums(int n) {
		Random rand = new Random();
		int[] myList = new int[n];
		for (int i = 0; i < n; i++) myList[i] = rand.nextInt(65536);
		return myList;
	}
	
	int[] asc_nums(int n) {
		int[] myList = new int[n];
		for (int i = 0; i < n; i++) myList[i] = i;
		return myList;
	}
	
	int[] dsc_nums(int n) {
		int[] myList = new int[n];
		for (int i = n; i > 0; i--) myList[i] = i;
		return myList;
	}
}


public class InsertionSort {
	private static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	private static void print(int[] nums, int x) {
		if (x > nums.length) x = nums.length;
		for (int i = 0; i < x; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	// InsertionSort algorithm
	private static void insertionSort(int[] nums) {
		// Write this function
		nums[0] = 12;
		return;
	}
	
	public static void main(String[] args) {
		ListCreator lc = new ListCreator();
		int[] nums = lc.rand_nums(10);
		
		insertionSort(nums);
	}
}
