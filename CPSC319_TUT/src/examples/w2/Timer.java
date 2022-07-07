// Author: Stéphane Dorotich
// CPSC 319 - Summer 2022
// Use freely
package examples.w2;

import java.lang.reflect.Method;

public class Timer {
	// Time
	// 	Used to time how long a method takes to run
	//	Return the time (in nanoseconds)
	public static long time(Object object, Method myFunc, Object[] params) throws Exception {
		Long time = System.nanoTime();
		myFunc.invoke(object, params);
		time = System.nanoTime() - time;
		double s = (double) time / 1_000_000_000;
		System.out.printf("%.4fs\n", s);
		return time;
	}
}
