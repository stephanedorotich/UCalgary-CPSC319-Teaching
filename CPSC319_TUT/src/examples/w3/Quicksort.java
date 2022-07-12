package examples.w3;

import examples.w2.ListCreator;

public class Quicksort {

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print('\n');
	}
	
	private static void quicksort(int[] arr, int lo, int hi) {
		return;
	}
	
	private static int partition(int[] nums, int lo, int hi) {
		return 0;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	private static int getPivot(int[] nums, int lo, int hi) {
		int mid = (hi - lo) / 2;
		if (nums[lo] > nums[hi]) {
			swap(nums, lo, hi);
		}
		if (nums[lo] > nums[mid]) {
			swap(nums, lo, mid);
		}
		if (nums[mid] > nums[hi]) {
			swap(nums, mid, hi);
		}
		return mid;
	}
	
	public static void main(String[] args) {
		int[] nums = ListCreator.rand_nums(10, 100);
		
		System.out.println("Unsorted");
		print(nums);
		
		quicksort(nums, 0, nums.length-1);

		System.out.println("\nSorted");
		print(nums);
	}
}
