package problems;
import java.util.HashSet;
import java.util.Set;

public class SetRowColumnZero {

	public static void setZeros(int[][] grid) {
		
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		
		for(int i=0 ; i<grid.length ; i++) {
			for(int j=0 ; j<grid[i].length ; j++) {
				if(grid[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int row : rows) {
			for(int i=0 ; i<grid[row].length ; i++) {
				grid[row][i] = 0;
			}
		}
		
		for(int col : cols) {
			for(int i=0 ; i<grid.length ; i++) {
				grid[i][col] = 0;
			}
		}
	}
	
	public static void showGrid(int[][] grid) {
		
		for(int[] a : grid) {
			for(int b : a) 
				System.out.print(b + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[][] grid = {{1, 1, 0, 1, 1},
						{1, 1, 1, 1, 1},
						{0, 1, 1, 1, 1},
						{1, 1, 1, 1, 1},
						{1, 1, 1, 1, 1}};
		
		System.out.println("Before \n");
		showGrid(grid);
		setZeros(grid);
		System.out.println("After \n");
		showGrid(grid);
	}
}
