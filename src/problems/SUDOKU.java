package problems;

public class SUDOKU {

	private boolean solveSudoku(Integer[][] grid) {
		
		Integer row = new Integer(0);
		Integer col = new Integer(0);
				
		if(!isLocationAvailable(grid, row, col)) {
			return true;
		}
		
		for(int n=1 ; n<=9 ; n++) {
			
			if(isCorrect(grid, n, row.intValue(), col.intValue())) {				
				
				grid[row][col] = n;
				if(solveSudoku(grid))
					return true;
				
				grid[row][col] = 0;
			}
		}
		
		return false;
	}
	
	private boolean isLocationAvailable(Integer[][] grid, Integer row, Integer col) {
		
		for(int i=0 ; i<grid.length ; i++) {
			for(int j=0 ; j<grid[i].length ; j++) {
				if(grid[i][j] == 0) {
					row = i;
					col = j;
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isCorrect(Integer[][] grid, int value, int row, int col) {
		
		return validateRow(grid, value, row) && validateCol(grid, value, col) && validateBox(grid, value, row, col);
	}
	
	private boolean validateRow(Integer[][] grid, int value, int row) {
		
		for(int i=0 ; i<grid[row].length ; i++) 
			if(grid[row][i] == value) 
				return false;
		
		return true;
	}
	
	private boolean validateCol(Integer[][] grid, int value, int col) {
		
		for(int i=0 ; i<grid.length ; i++) 
			if(grid[i][col] == value) 
				return false;
		
		return true;
	}
	
	private boolean validateBox(Integer[][] grid, int value, int row, int col) {
		
		for(int i=row ; i<row+3 ; i++) {
			for(int j=col ; j<col+3 ; j++) {
				if(grid[i][j] == value)
					return false;
			}
		}
		return true;
	}
	
	public void showGrid(Integer[][] grid) {
		
		for(Integer[] row : grid) {
			for(Integer col : row) 
				System.out.print(col + " ");
			System.out.println();
		}
	}
	
	public void start() {
		
		Integer[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
			 				{5, 2, 0, 0, 0, 0, 0, 0, 0},
			 				{0, 8, 7, 0, 0, 0, 0, 3, 1},
			 				{0, 0, 3, 0, 1, 0, 0, 8, 0},
			 				{9, 0, 0, 8, 5, 3, 0, 0, 5},
			 				{0, 5, 0, 0, 9, 0, 6, 0, 0},
			 				{1, 3, 0, 0, 0, 0, 2, 5, 0},
			 				{0, 0, 0, 0, 0, 0, 0, 7, 4},
			 				{0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		System.out.println("Before : \n");
		showGrid(grid);
		solveSudoku(grid);
		System.out.println("\nAfter : \n");
		showGrid(grid);		
	}
	
	public static void main(String [] args) {
		
		SUDOKU sud = new SUDOKU();
		sud.start();
	}
}
