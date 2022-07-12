package examples.w3;

public class Recursion {

	static void findFactors(int n, int factor) {
		if (factor > n) return;
		if (n % factor == 0) System.out.println(factor);
		findFactors(n, ++factor);
	}
	
	static void someRecursiveFunction(int n) {		
		// WARNING: ALL RECURSIVE FUNCTIONS MUST HAVE A BASE CASE TO STOP RECURSION!
		//			OTHERWISE YOU WILL CAUSE A STACK OVERFLOW ERROR
		System.out.println("Hello");
		someRecursiveFunction(--n);
	}
	
	
	public static void main(String[] args) {
		someRecursiveFunction(10);
	}
}
