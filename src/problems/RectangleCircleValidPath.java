package problems;

public class RectangleCircleValidPath {

	public static void main(String[] args) {
		
		int m = 5;
		int n = 5;
		int k = 2;
		int r = 1;
		int[] X = {1, 3};
		int[] Y = {3, 3};
		
		System.out.println(isPossible(m, n, k, r, X, Y) ? "YES" : "NO");
	}
	
	public static boolean isPossible(int m, int n, int k, int r, int[] X, int[] Y) {
		
		int[][] rect = new int[m][n];
		
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				for(int p=0 ; p<k ; p++) {
					double total = Math.pow(Math.abs(i+1-X[p]), 2) + Math.pow(Math.abs(j+1-Y[p]), 2);
					if(Math.sqrt(total) <= r) {
						rect[i][j] = -1;
					}
				}
			}
		}
		
		return isPossible(rect, 0, 0, m, n);
	}
	
	private static boolean isPossible(int[][] rect, int i, int j, int L, int R) {
		
		if(i == L || j == R || rect[i][j] == -1) 
			return false ;
		if((i == L-1 && j == R-1) || rect[i][j] == 1) 
			return true ;
		
		rect[i][j] = isPossible(rect, i, j+1, L, R) || isPossible(rect, i+1, j, L, R) ? 1 : -1;
		return rect[i][j] == 1;
	}
}
