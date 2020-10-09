package problems;

public class RescueThePrinces {

	public static void calculateMinimumInitialHealth(int[][] grid, int row, int col) {
		
		int[][] R = new int[row][col];
		int[][] C = new int[row][col];
		
		if(grid[0][0] < 0) {
			R[0][0] = Math.abs(grid[0][0]);
			C[0][0] = 0;
		} else {
			R[0][0] = 0;
			C[0][0] = grid[0][0];
		}
		
		//calculate first row
		for(int i=1 ; i<row ; i++) {
			if(C[0][i-1] + grid[0][i] < 0) {
				R[0][i] = R[0][i-1] + (Math.abs(C[0][i-1] - grid[0][i]));
				C[0][i] = 0;
			} else {
				R[0][i] = R[0][i-1];
				C[0][i] = C[0][i-1] + grid[0][i];
			}
		}
		
		//calculate first column
		for(int i=1 ; i<col ; i++) {
			if(C[i-1][0] + grid[i][0] < 0) {
				R[i][0] = R[i-1][0] + (Math.abs(C[i-1][0] - grid[i][0]));
				C[i][0] = 0;
			} else {
				R[i][0] = R[i-1][0];
				C[i][0] = C[i-1][0] + grid[i][0];
			}
		}
		
		//calculate remaining cells
		for(int i=1 ; i<row ; i++) {
			for(int j=1 ; j<col ; j++) {
				
			}
		}
		
		//print
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				System.out.print(R[i][j] + "/" + C[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		int[][] grid = {{-2, -3, 3},
						{-5, -10, 1},
						{10, 30, -10}};
		
		calculateMinimumInitialHealth(grid, 3, 3);
	}
}
