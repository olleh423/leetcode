package problems;

public class MinCostPath {

	public int minCostPath(int[][] arr, int r, int c) {
		
		for(int i=1 ; i<r ; i++) 
			arr[0][i] += arr[0][i-1] ;
		
		for(int j=1 ; j<c ; j++) 
			arr[j][0] += arr[j-1][0] ;
		
		for(int i=1 ; i<r ; i++) {
			for(int j=1 ; j<c ; j++) {
				arr[i][j] += min(arr[i][j-1], arr[i-1][j], arr[i-1][j-1]) ;
			}
		}
		
		return arr[r-1][c-1] ;

	}
	
	public int min(int a, int b, int c) {
		
		return a < b ? a < c ? a : c : b < c ? b : c;
	}
	
	public static void main(String[] args) {
		
		int[][] grid = {{1, 2, 3},
						{4, 8, 2},
						{1, 5, 3}};
		
		MinCostPath msp = new MinCostPath();
		System.out.println("Size of minimum cost path : " + msp.minCostPath(grid, 3, 3));
	}
}
