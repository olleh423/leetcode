package problems;

public class WaysToHome {

	/*A frog lives on the axis Ox and needs to reach home which is in the point n. 
	 * She starts from the point 1. The frog can jump to the right at a distance not more than d. 
	 * So, after she jumped from the point x she can reach the point x + a, where a is an integer from 1 to d.*/
	
	private static int solve(int c, int n, int d, String s, int[] res) {
		
		if(c == n) return 0;
		if(c > n || s.charAt(c) == '0') return -1;
		
		if(res[c] != -2) return res[c];
		
		int min = Integer.MAX_VALUE;
		for(int i=1 ; i<=d ; i++) {
			int value = solve(c + i, n, d, s, res);
			if(value != -1) 
				min = Math.min(min, 1 + value);
		}
		res[c] = min == Integer.MAX_VALUE ? -1 : min;
		return res[c];
	}
	
	private static int solve(String s, int n, int d) {
		
		int[] res = new int[n];
		for(int i=0 ; i<res.length ; i++) res[i] = -2;
		
		return solve(0, n - 1, d, s, res);
	}
	
	public static void main(String[] args) throws Exception {
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		int n = scan.nextInt();
		int d = scan.nextInt();
		String s = scan.next();
		System.out.println(solve(s, n, d));
	}
}
