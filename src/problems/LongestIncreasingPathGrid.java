package problems;

/*
 * Longest path starting from any cell with given constraints
 * 
 * constraints : path should be increased by 1
 */

public class LongestIncreasingPathGrid {
	
	private static class Move {
		int i, j;
		Move(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private static Move[] getMoves() {
		
		Move[] moves = new Move[4];
		
		moves[0] = new Move(0, -1);
		moves[1] = new Move(-1, 0);
		moves[2] = new Move(0, 1);
		moves[3] = new Move(1, 0);
		
		return moves;
	}
	
	private int row;
	private int col;
	private int[][] grid;
	private Move[] moves;
	
	public LongestIncreasingPathGrid(int row, int col, int[][] grid) {
		
		this.row = row;
		this.col = col;
		this.grid = grid;
		this.moves = getMoves();
	}

	private boolean isValid(int i, int j, int current) {
		
		if((i >= 0 && i < row) && (j >= 0 && j < col) && current + 1 == grid[i][j])
			return true;
		return false;
	}
	
	private int DFS(int i, int j) {
		
		int total = 1;
		for(Move m : moves) {
			if(isValid(m.i + i, m.j + j, grid[i][j])) {
				total = Math.max(total, 1 + DFS(m.i + i, m.j + j));
			}
		}
		
		return total;
	}
	
	private int DFS_DP(int i, int j, int[][] DP) {
		
		if(DP[i][j] != 0)
			return DP[i][j];
		
		DP[i][j] = 1;
		for(Move m : moves) {
			if(isValid(m.i + i, m.j + j, grid[i][j])) {
				DP[i][j] = Math.max(DP[i][j], 1 + DFS_DP(m.i + i, m.j + j, DP));
			}
		}
		
		return DP[i][j];
	}
	
	public int getLength() {
		
		int max = 0;
		
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				max = Math.max(max, DFS(i, j));
			}
		}
		
		return max;
	}
	
	public int getLength_DP() {
		
		int[][] DP = new int[row][col];
		
		int max = 0;
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				max = Math.max(max, DFS_DP(i, j, DP));
			}
		}
		
		return max;
	}
	
	// Driver method
	public static void main(String[] args) {
		
		int row = 3;
		int col = 3;
		int[][] grid = {{1, 2, 9},
						{5, 3, 8},
						{4, 6, 7}};
		
		LongestIncreasingPathGrid obj = new LongestIncreasingPathGrid(row, col, grid);
		
		System.out.println("Length of longest increasing path : " + obj.getLength());
		System.out.println("Length of longest increasing path : " + obj.getLength_DP());
	}
}
