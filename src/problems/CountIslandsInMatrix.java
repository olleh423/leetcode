package problems;

/*
	Given a boolean 2D matrix, find the number of islands. 
	A group of connected 1s forms an island. For example, the below matrix contains 5 islands
	
	Example:
	
	Input : mat[][] = {{1, 1, 0, 0, 0},
	                   {0, 1, 0, 0, 1},
	                   {1, 0, 0, 1, 1},
	                   {0, 0, 0, 0, 0},
	                   {1, 0, 1, 0, 1} 
	Output : 5
	
*/

public class CountIslandsInMatrix {
	
	private int row, col;
	
	public CountIslandsInMatrix(int row, int col) {
		
		this.row = row;
		this.col = col;
	}
	
	private static class Move {
		int i, j;
		Move(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private static class Size {
		int size;
		Size(int size) {
			this.size = size;
		}
	}
	
	private static class Result {
		int sizeOfLargest;
		int totalIsland;
		Result(int sizeOfLargest, int totalIsLand) {
			this.sizeOfLargest = sizeOfLargest;
			this.totalIsland = totalIsLand;
		}
	}
	
	private Move[] getMoves() {
		
		Move[] moves = new Move[8];
		
		moves[0] = new Move(-1, -1);
		moves[1] = new Move(-1, 0);
		moves[2] = new Move(-1, 1);
		moves[3] = new Move(0, 1);
		moves[4] = new Move(1, 1);
		moves[5] = new Move(1, 0);
		moves[6] = new Move(1, -1);
		moves[7] = new Move(0, -1);
		
		return moves;
	}
	
	private boolean isSafe(int i, int j, int[][] grid, boolean[][] visited) {
		
		return (i < row && i >=0 ) && (j < col && j >= 0) && (grid[i][j] == 1 && !visited[i][j]);
	}
	
	private Size DFS(int row, int col, int[][] grid, boolean[][] visited, Move[] moves, Size size) {
		
		visited[row][col] = true;
		for(Move move : moves) {
			
			if(isSafe(row + move.i, col + move.j, grid, visited)) {
				
				size.size += 1;
				DFS(row + move.i, col + move.j, grid, visited, moves, size);
			}
		}
		
		return size;
	}
	
	public Result countIsLand(int[][] arr) {
		
		boolean[][] visited = new boolean[row][col];
		Move[] moves = getMoves();
		
		int count = 0;
		int MAX = Integer.MIN_VALUE;
		for(int i=0 ; i<row ; i++) {
			
			for(int j=0 ; j<col ; j++) {
				
				if(arr[i][j] == 1 && !visited[i][j]) {
					
					Size size = new Size(1);
					MAX = Math.max(MAX, DFS(i, j, arr, visited, moves, size).size);
					count++;
				}
			}
		}
		
		return new Result(MAX, count);
	}

	public static void main(String[] args) {
		
		int row = 5;
		int col = 5;
		int mat[][] = { {0, 1, 0, 1, 1},
		                {0, 1, 0, 1, 1},
		                {1, 0, 0, 1, 1},
		                {0, 0, 0, 1, 0},
		                {1, 1, 0, 1, 1} };
		
		CountIslandsInMatrix obj = new CountIslandsInMatrix(row, col);
		Result result = obj.countIsLand(mat);
		System.out.println("Total islands : " + result.totalIsland);
		System.out.println("Size of largest island : " + result.sizeOfLargest);
	}
}
