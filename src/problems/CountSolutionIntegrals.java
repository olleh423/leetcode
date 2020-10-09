package problems;

public class CountSolutionIntegrals {

	public static int count(int val, int n) {
		
		if(val < 0)
			return 0;
		
		if(n == 5)
			return val >= 0 ? 1 : 0;
		
		int total = 0;
		for(int i=0 ; i<=val ; i++) {
			total += count(val - pow(i, n), n+1);
		}

		return total;
	}
	
	public static int pow(int a, int b) {
		return (int) Math.pow(a, b);
	}
	
	public static int count(int s) {
		
		return count(s, 1);
	}
	
	public static void main(String[] args) {
		
		int s = 2;
		
		System.out.println(count(s));
	}
}
