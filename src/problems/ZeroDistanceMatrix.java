package problems;

import java.util.Arrays;

public class ZeroDistanceMatrix {
	
	static class Move {
		int i;
		int j;
		Move(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private static final Move[] moves = new Move[4];
	
	public ZeroDistanceMatrix() {

		moves[0] = new Move(0, -1);
		moves[1] = new Move(-1, 0);
		moves[2] = new Move(0, 1);
		moves[3] = new Move(1, 0);
	}
	
	private int getDistance(int i, int j, int[][] mat, boolean[][] visiting, int rows, int cols, int[][] result) {
		
		if(mat[i][j] == 0)
			return 0;
		
		if(result[i][j] != -1)
			return result[i][j];
		
		int min = Integer.MAX_VALUE;
		visiting[i][j] = true;
		
		for(Move m : moves) {
			
			int next_i = i + m.i;
			int next_j = j + m.j;
			
			if(next_i >= 0 && next_i < rows && next_j >= 0 && next_j < cols && !visiting[next_i][next_j]) {
				
				int dist = 1 + getDistance(next_i, next_j, mat, visiting, rows, cols, result);
				min = dist < min ? dist : min;
			}
		}
		
		visiting[i][j] = false;
		return min;
	}
	
	
	/*
	 * BFS brute force solution
	 * Runtime : O(nm*nm)
	 * Space : O(nm);
	 */
	public void solve(int[][] mat, int rows, int cols) {
		
		if(rows == 0 || cols == 0 || mat == null)
			return;
		
		int[][] result = new int[rows][cols];
		boolean[][] visiting = new boolean[rows][cols];
		
		for(int i=0;  i<rows ; i++)
			Arrays.fill(result[i], -1);
		
		for(int i=0 ; i<rows ; i++) {
			
			for(int j=0 ; j<cols ; j++) {
				
				result[i][j] = getDistance(i, j, mat, visiting, rows, cols, result);
			}
		}
		
		for(int[] arr : result) {
			for(int a : arr) {
				System.out.print(a == Integer.MAX_VALUE ? "X  " : a + "  ");
			}
			System.out.println("\n");
		}
	}
	
	/*
	 * solution using dynamic programming in two passes first from top left second from bottom right
	 * Run time = O(nm)
	 * Space = O(nm);
	 */
	public void solveDP(int[][] mat, int rows, int cols) {
		
		if(rows == 0 || cols == 0 || mat == null)
			return;
		
		int[][] result = new int[rows][cols];
		
		for(int i = 0 ; i < rows ; i++) {
			
			for(int j = 0 ; j < cols ; j++) {
				
				if(mat[i][j] == 0)
					result[i][j] = 0;
				else if(i == 0 && j == 0)
					result[i][j] = Integer.MAX_VALUE;
				else if(i == 0)
					result[i][j] = result[i][j-1] != Integer.MAX_VALUE ? 1 + result[i][j-1] : Integer.MAX_VALUE;
				else if(j == 0)
					result[i][j] = result[i-1][j] != Integer.MAX_VALUE ? 1 + result[i-1][j] : Integer.MAX_VALUE;
				else 
					result[i][j] = Math.min(result[i-1][j], result[i][j-1]) != Integer.MAX_VALUE ? 1 + Math.min(result[i-1][j], result[i][j-1]) : Integer.MAX_VALUE; 
			}
		}
		
		for(int i = rows - 1 ; i >= 0 ; i--) {
			
			for(int j = cols - 1 ; j >= 0 ; j--) {
				
				int current = result[i][j];
				
				if(mat[i][j] == 0)
					result[i][j] = 0;
				else if(i == rows-1 && j < cols-1)
					result[i][j] = Math.min(current, 1 + result[i][j+1]);
				else if(j == cols-1 && i < rows-1)
					result[i][j] = Math.min(current, 1 + result[i+1][j]);
				else if(i != rows-1 && j != cols-1)
					result[i][j] = Math.min(current, 1 + Math.min(result[i][j+1], result[i+1][j]));
			}
		}
		
		
		//Display results
		for(int[] arr : result) {
			for(int a : arr) {
				System.out.print(a + "  ");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		
		/*int[][] mat = { {0, 0, 0},
						{0, 1, 0},
						{1, 1, 1} };*/
		
		int[][] mat = { {1,0,1,1,0,0,1,0,0,1},
						{0,1,1,0,1,0,1,0,1,1},
						{0,0,1,0,1,0,0,1,0,0},
						{1,0,1,0,1,1,1,1,1,1},
						{0,1,0,1,1,0,0,0,0,1},
						{0,0,1,0,1,1,1,0,1,0},
						{0,1,0,1,0,1,0,0,1,1},
						{1,0,0,0,1,1,1,1,0,1},
						{1,1,1,1,1,1,1,0,1,0},
						{1,1,1,1,0,1,0,0,1,1} };
		
		int rows = 10;
		int cols = 10;
		
		ZeroDistanceMatrix obj = new ZeroDistanceMatrix();
		obj.solveDP(mat, rows, cols);
	}
}
