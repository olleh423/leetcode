package problems;

public class Largest1sSQuare {

	public void calculate(int[][] grid, int row, int col) {
		
		int[][] results = new int[row][col];
		int maxSize = 0;
		
		for(int i=0 ; i<grid.length ; i++) {
			
			for(int j=0 ; j<grid[i].length ; j++) {
				
				if(i == 0 || j == 0 || grid[i][j] == 0) {
					results[i][j] = grid[i][j];
				}
				else {
					results[i][j] = 1 + min(results[i][j-1], results[i-1][j], results[i-1][j-1]);
					maxSize = maxSize < results[i][j] ? results[i][j] : maxSize;
				}
			}
		}
		
		System.out.println(maxSize);
	}
	
	public int min(int a, int b, int c) {
		
		return a < b ? a < c ? a : c : b < c ? b : c;
	}
	
	public static void main(String... args) {
		
		int[][] grid = {{1, 0, 0, 1, 1, 1},
						{0, 1, 1, 1, 0, 1},
						{1, 1, 1, 1, 1, 0},
						{0, 1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1, 0},
						{0, 1, 1, 1, 1, 1}};
		
		Largest1sSQuare obj = new Largest1sSQuare();
		
		obj.calculate(grid, 6, 6);
	}
}
