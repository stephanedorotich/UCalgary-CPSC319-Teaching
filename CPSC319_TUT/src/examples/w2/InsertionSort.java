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
	public static void insertionSort(int[] nums) {
		// Write this function
		int i = 1;
		int x, j;
		while (i < nums.length) {
			x = nums[i];
			j = i - 1;
			while (j >=0 && nums[j] > x) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = x;
			i++;
		}
		return;
	}
	
	public static void main(String[] args) {
		// time with 50,000
		// switch rand_nums, dsc_nums
		int[] nums = ListCreator.rand_nums(100000);
		
		long time = System.nanoTime();
		insertionSort(nums);
		time = System.nanoTime() - time;
		
		System.out.printf("%.4fs\n", (double) time / 1_000_000_000);
		
		print(nums, 12);
	}
}
