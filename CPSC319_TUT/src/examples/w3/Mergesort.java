package examples.w3;

import examples.w2.ListCreator;

public class Mergesort {

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print('\n');
	}
	
	public static void merge(int[] arr, int begin, int mid, int end) {		
		// create temp arrays
		
		// copy data to temp arrays
		
		// create initial indices for the Left, Right, and original arrays (0, 0, and begin)\
		
		// compare values in arrays and add the smaller one to the original arr
		
		// take remaining elements and place them in final array
		return;
	}
	
	public static void mergesort(int[] arr, int begin, int end) {
		
	}
	 
	public static void main(String[] args) {
		int[] nums = ListCreator.rand_nums(10, 100);
		
		System.out.println("Unsorted");
		print(nums);
		
		mergesort(nums, 0, nums.length-1);

		System.out.println("\nSorted");
		print(nums);
	}
}