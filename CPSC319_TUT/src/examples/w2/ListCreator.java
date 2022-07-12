package examples.w2;

import java.util.Random;

public class ListCreator {
	public static int[] rand_nums(int n) {
		Random rand = new Random();
		int[] myList = new int[n];
		for (int i = 0; i < n; i++) myList[i] = rand.nextInt(65536);
		return myList;
	}
	
	public static int[] rand_nums(int n, int max) {
		Random rand = new Random();
		int[] myList = new int[n];
		for (int i = 0; i < n; i++) myList[i] = rand.nextInt(max);
		return myList;
	}
	
	public static int[] asc_nums(int n) {
		int[] myList = new int[n];
		for (int i = 0; i < n; i++) myList[i] = i;
		return myList;
	}
	
	public static int[] dsc_nums(int n) {
		int[] myList = new int[n];
		int val = n;
		for (int i = 0; i < n; i++) {
			myList[i] = val;
			val--;
		}
		return myList;
	}
}
