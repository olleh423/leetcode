package problems;

public class RoundTableElemination {

	public static int getSafeIndex(int n, int k) {
		
		if(n == 1) return n;
		
		return (getSafeIndex(n-1, k) + k - 1) % n + 1;
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		int k = 5;
		
		System.out.println(getSafeIndex(n, k));
	}
}
