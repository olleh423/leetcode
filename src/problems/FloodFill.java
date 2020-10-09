package problems;

public class FloodFill {
	
	public void fill(int[][] grid, int row, int col, int i, int j, int K, int value) {
		
		if(i < 0 || i == row || j < 0 || j == col || grid[i][j] != value) return;
		
		grid[i][j] = K;
		
		fill(grid, row, col, i-1, j, K, value);		
		fill(grid, row, col, i, j-1, K, value);
		fill(grid, row, col, i+1, j, K, value);
		fill(grid, row, col, i, j+1, K, value);
	}
	
	public void showGrid(int[][] arr) {
		
		for(int[] i : arr) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int[][] grid = {{0, 1, 1, 0},
						{1, 1, 1, 1},
						{0, 1, 2, 3}};
		
		int row=3, col=4;
		int x=1, y=2, K=5;
		
		FloodFill ff = new FloodFill();
		
		System.out.println("Before : ");
		ff.showGrid(grid);
		
		ff.fill(grid, row, col, x, y, K, grid[x][y]);
		
		System.out.println("\nAfter : ");
		ff.showGrid(grid);
	}
}
