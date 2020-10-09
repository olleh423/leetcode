package problems;

public class ModifiedFibb {

	public static long fibb(int t1, int t2, int n, long[] result) {
		
		if(n == 1) return t1;
		if(n == 2) return t2;
		if(result[n-1] != 0) return result[n-1];
		
		long value = (long) (Math.pow(fibb(t1, t2, n-1, result), 2) + fibb(t1, t2, n-2, result));
		result[n-1] = value;
		return value;
	}
	
	public static void main(String[] args) {
		
		System.out.println(fibb(0, 1, 10, new long[10]));
	}
}
