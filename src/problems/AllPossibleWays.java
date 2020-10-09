package problems;

public class AllPossibleWays {
	
	private int countDynamic(int[][] grid, boolean[][] memo, int row, int col, int ci, int cj, int count) {
		
		if((ci == row-1 && cj == col-1) || memo[ci][cj]) {			
			return ++count;
		}
		
		if(cj < col-1 && grid[ci][cj + 1] == 0) 
			count = countDynamic(grid, memo, row, col, ci, cj + 1, count);

		if(ci < row-1 && grid[ci + 1][cj] == 0)
			count = countDynamic(grid, memo, row, col, ci + 1, cj, count);
		
		memo[ci][cj] = true;
		
		return count;
	}

	private int count(int[][] grid, int row, int col, int ci, int cj, int count) {
				
		if(ci == row-1 && cj == col-1) return ++count;
		
		if(cj < col-1 && grid[ci][cj + 1] == 0) 
			count = count(grid, row, col, ci, cj + 1, count);

		if(ci < row-1 && grid[ci + 1][cj] == 0)
			count = count(grid, row, col, ci + 1, cj, count);
		
		return count;
	}
	
	public int countWays(int[][] grid, int row, int col) {
		
		return count(grid, row, col, 0, 0, 0);
	}
	
	public int countWaysDynamic(int[][] grid, int row, int col) {
				
		return 1 + countDynamic(grid, new boolean[row][col], row, col, 0, 0, 0);
	}
	
	public static void main(String... args) {
		
		int row = 3, col = 3;
		int[][] grid = {{0, 0, 0},
						{0, 0, 0},
						{0, 0, 0}};
		
		AllPossibleWays ways = new AllPossibleWays();
		System.out.println("Number of ways are : " + ways.countWaysDynamic(grid, row, col));
	}
}
