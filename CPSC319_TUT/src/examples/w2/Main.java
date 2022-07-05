// Author: Stéphane Dorotich
// CPSC 319 - Summer 2022
// Use freely
package examples.w2;

import java.lang.reflect.Method;

public class Main {
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
	
	public static void main(String[] args) throws Exception {
		// Testing func9
		Class[] parameterTypes = new Class[2];
		parameterTypes[0] = Integer.class;
		parameterTypes[1] = Integer.class;
		Object[] parameters = new Object[2];
		Method functionToPass = PrimOps.class.getMethod("func9", parameterTypes);
		parameters[0] = 5;
		parameters[1] = -1;
		long time_f9 = time(parameterTypes, functionToPass, parameters);
		
		
		// Testing func5
		Class[] f5_parameterTypes = new Class[1];
		f5_parameterTypes[0] = Integer.class;
		Object[] f5_parameters = new Object[1];
		Method f5_func = PrimOps.class.getMethod("func5", f5_parameterTypes);
		long time_f5 = 0;
		for (int i = 1000; i < 1010; i++) {
			f5_parameters[0] = i;
			time_f5 += time(f5_parameterTypes, f5_func, f5_parameters);
		}
		System.out.println("Avg time: " + time_f5 / 10);
	}	
}
