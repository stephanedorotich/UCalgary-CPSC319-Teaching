package examples.w3;

import examples.w2.ListCreator;
import examples.w2.InsertionSort;

public class CompareSortingAlgorithms {
	public static void main(String[] args) {
	
		int size = 75000;
		// create two identical arrays
		int[] nums1 = ListCreator.rand_nums(size);
		int[] nums2 = new int[size];
		for (int i = 0; i < size; i++) {
			nums2[i] = nums1[i];
		}
		
		// time insertion sort
		long time1 = System.nanoTime();
		InsertionSort.insertionSort(nums1);
		time1 = System.nanoTime() - time1;
		
		// time merge sort
		long time2 = System.nanoTime();
		Mergesort_mine.mergesort(nums2, 0, nums2.length-1);
		time2 = System.nanoTime() - time2;

		// print results
		System.out.printf("ISort:     %.4fs\n", (double) time1 / 1_000_000_000);
		System.out.printf("MSort:     %.4fs\n", (double) time2 / 1_000_000_000);
	}
}
