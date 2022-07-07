// Author: Stéphane Dorotich
// CPSC 319 - Summer 2022
// Use freely
package examples.w2;

import examples.w1.Rectangle;
import java.lang.Math;
import java.lang.reflect.Method;

public class PrimOps {

	public static Long func1(Integer n) {
		Long x = 0L;
		x = x - 3;
		System.out.println("Hello");
		return x;
	}
	
	public static Long func2() {
		Rectangle r = new Rectangle(3, 4);
		Long area = (long) r.length * r.width;
		return area;
	}
	
	public static void func3(Integer n) {
		int i = 0;
		while (i < n) {
			String myString = "Hello\n";
			i++;
		}
	}
	
	public static void func4(Integer n) {
		for (int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}
	}
	
	public static long func5(Integer n) {
		long someVal = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				someVal+= j;
			}
		}
		return someVal;
	}
	
	public static void func6(Integer n) {
		for (int i = 0; i < n; i++) {
			int someVal = i;
			someVal = someVal*2 - 77;
			for (int j = 0; j < 100; j++) {
				System.out.println("Hello");
			}
		}
	}
	
	public static void func7(Integer n) {
		for (int x = n; x > 0; x/=2) { //log(n)+1
			System.out.print(x + " ");
		}
	}
	
	public static void func8(Integer n) {
		for (int y = 1; y < n; y*=2) {
			System.out.print(y + " ");
		}
	}
	
	public static void func9(Integer n) {
		Integer key = -1;
		if (n > 18) {
			System.out.println("Overflow");
			return;
		} else {
			long max = (long) Math.pow(10, n);
			for (long i = 0; i < max; i++) {
				if (i == key) break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Creating a Method reference for a function
		Class<?>[] parameterTypes = {Integer.class}; // need to know what parameters (args) the function requires
		Method functionToPass = PrimOps.class.getMethod("func1", parameterTypes); // create a Method object for function
		Object[] parameters = {1000}; // set the parameter we'd like to pass to the function.
		
		long time = Timer.time(parameterTypes, functionToPass, parameters);
	}
}













