package examples.w2;

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
		int[] nums = ListCreator.rand_nums(10);
		
		insertionSort(nums);
		
		print(nums);
	}
}
