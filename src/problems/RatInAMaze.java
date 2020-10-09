package problems;

public class RatInAMaze {
	
	private boolean solve(int[][] grid, int n, int m, int i, int j) {
		
		if(i == n - 1 && j == m - 1)
			return grid[i][j] == 1;
		
		if(i == n || j == m || grid[i][j] == 0)
			return false;
		
		return solve(grid, n, m, i+1, j) || solve(grid, n, m, i, j+1);
	}
	
	public boolean isEscapeAvailable(int[][] grid, int n, int m) {
		
		return solve(grid, n, m, 0, 0);
	}

	public static void main(String[] args) {
		
		int[][] grid = {{1, 1, 1, 0, 0, 0},
						{1, 0, 1, 1, 1, 1},
						{1, 0, 1, 0, 0, 0},
						{1, 0, 1, 1, 1, 1},
						{1, 1, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 1}};
		int n = 6;
		int m = 6;
		
		RatInAMaze obj = new RatInAMaze();
		
		System.out.println(obj.isEscapeAvailable(grid, n, m));
	}
}
