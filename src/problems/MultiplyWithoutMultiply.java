package problems;

public class MultiplyWithoutMultiply {
	
	/*
	 * Recursive solution optimized O(log b)
	 */
	private int multiplyOptimize(int a, int b) {
		
		if(a == 0)
			return multiplyOptimize(b, a);
		
		if(b == 0)
			return 0;
		
		int value = multiplyOptimize(a, b / 2);
		return b % 2 == 0 ? value + value : value + value + a;
	}

	/*
	 * Linear brute force recursive solution O(b);
	 * will lead to StackOverflow for big values
	 */
	private int multiply(int a, int b)
	{
		if(a == 0)
			return multiply(b, a);
		
		if(b == 0)
			return 0;
		
		return a + multiply(a, b - 1);
	}
	
	public static void main(String[] args) {
		
		int a = 5;
		int b = 41;
		
		MultiplyWithoutMultiply obj = new MultiplyWithoutMultiply();
		
		System.out.println(obj.multiply(a, b));
		System.out.println(obj.multiplyOptimize(a, b));
	}
}
