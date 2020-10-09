package problems;

/*
 * 
 * Given a NxM matrix contains only 0 or 1. 
 * 1 indicates valid cell and 0 indicates invalid cell. you can only move to valid cell.
 * 
 * find is there any way to reach bottom right corner.
 * you are initially at top right corner. you can move only right and down.
 * 
 */

public class ZeroOnePathMatrix {
	
	public static void main(String [] args) {
		
		int[][] m = new int[][] {{1,1,0,0,0,1,0,1},
						 		 {0,1,0,0,0,0,0,0},
						 		 {0,1,1,1,1,0,0,0},
						 		 {0,0,0,0,1,1,0,0},
						 		 {0,0,1,1,0,1,0,0},
						 		 {0,0,1,0,1,1,0,0},
						 		 {0,0,1,0,0,1,0,0},
						 		 {0,0,1,1,1,0,1,1}} ;

		System.out.println(hasRoute(8, m) ? "Available" : "Not Available") ;
	}

	public static boolean hasRoute(int n, int[][] m) {
		
		return hasRoute(0, 0, n, n, m) ;
	}

	public static boolean hasRoute(int i, int j, int L, int R, int[][] m) {
		
		if(i == L || j == R || m[i][j] == 0) 
			return false ;
		if(i == L-1 && j == R-1) 
			return true ;
		
		return hasRoute(i, j+1, L, R, m) || hasRoute(i+1, j, L, R, m);
	}
}
