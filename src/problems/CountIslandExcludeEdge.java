package problems;

/*
 * Count number of isLands in a matrix contains 0 and 1.
 * Island is a group of connected 1's 
 * if Island starts from the edge of the grid will not be considered as island.
 * 
 * E.g.
 * 		{{1, 0, 0, 0, 0},
		 {1, 1, 0, 1, 0},
		 {0, 0, 1, 1, 0},
		 {1, 0, 0, 0, 0}};
		 
		output : 1
		
		total island in the given grid is 3 but 1 is valid
 */

public class CountIslandExcludeEdge {
	
	private static boolean explore(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited) {
		
		if(i < 0 || j < 0 || i >= rows || j >= cols)
			return false;
		
		visited[i][j] = true;
		
		if((grid[i][j] == 1) && (i == 0 || j == 0 || i == rows-1 || j == cols-1))
			return false;
		
		if(grid[i][j] == 0)
			return true;
		
		return explore(i, j-1, rows, cols, grid, visited)
				&& explore(i-1, j, rows, cols, grid, visited)
				&& explore(i, j+1, rows, cols, grid, visited)
				&& explore(i+1, j, rows, cols, grid, visited);
	}

	public static int countIsland(int[][] grid, int rows, int cols) {
		
		if(grid == null)
			return 0;
		
		boolean[][] visited = new boolean[rows][cols];
		
		int totalIsland = 0;
		for(int i=0 ; i<rows ; i++) {
			for(int j=0 ; j<cols ; j++) {
				if(grid[i][j] == 1 && !visited[i][j] && explore(i, j, rows, cols, grid, visited)) {
					totalIsland++;
				}
			}
		}
		
		return totalIsland;
	}
	
	public static void main(String[] args) {
		
		int[][] grid = {{1, 0, 0, 0, 0},
						{1, 1, 0, 1, 0},
						{0, 0, 1, 1, 0},
						{1, 0, 0, 0, 0}};
		
		int rows = 4;
		int cols = 5;
		
		System.out.println(countIsland(grid, rows, cols));
	}
}
