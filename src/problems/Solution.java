package problems;

/*
		A pawn can move on 10x10 chequerboard horizontally, vertically and diagonally by these rules:
		
		1. 3 tiles moving North (N), West (W), South (S) and East (E)
		2. 2 tiles moving NE, SE, SW and NW
		3. Moves are only allowed if the ending tile exists on the board
		4. Starting from initial position, the pawn can visit each cell only once
		
		Find at least one path for the pawn to visit all tiles on the board following
		the above rules, starting from any tile.
 */

public class Solution {

	private static class Move {
		int x;
		int y;
		Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int boardSize = 8;
	
	public void solve() {
		
		Move[] moves = new Move[8];
		
		moves[0] = new Move(0, 3);
		moves[1] = new Move(2, 2);
		moves[2] = new Move(3, 0);
		moves[3] = new Move(2, -2);
		moves[4] = new Move(0, -3);
		moves[5] = new Move(-2, -2);
		moves[6] = new Move(-3, 0);
		moves[7] = new Move(-2, 2);
		
		int[][] result = new int[boardSize][boardSize];
		for(int i=0 ; i<result.length ; i++)
			for(int j=0 ; j<result[i].length ; j++)
				result[i][j] = -1;
		
		result[0][0] = 0;
		
		if(solve(0, 0, 1, result, moves)) {
			showResults(result);
		} else {
			System.out.println("No solution exists..");
		}
	}
	
	private boolean solve(int x, int y, int current, int[][] result, Move[] moves) {
		
		if(current == boardSize * boardSize)
			return true;
		
		for(int i=0 ; i<moves.length ; i++) {
			
			int xNext = x + moves[i].x;
			int yNext = y + moves[i].y;
			
			if(isValid(xNext, yNext, result)) {
				
				result[xNext][yNext] = current;
				
				if(solve(xNext, yNext, current + 1, result, moves))
					return true;
				else
					result[xNext][yNext] = -1;
			}
		}
		
		return false;
	}
	
	private boolean isValid(int x, int y, int[][] result) {
		
		return (x >= 0 && x < boardSize && y >= 0 && y < boardSize && result[x][y] == -1);
	}
	
	private void showResults(int[][] result) {
		
		for(int[] a : result) {
			for(int b : a) {
				System.out.print(b + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		sol.solve();
	}
}
