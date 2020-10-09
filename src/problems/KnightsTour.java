package problems;
import java.util.ArrayList;
import java.util.List;


public class KnightsTour {

	private static class Move {
		int i, j;
		Move(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public void tour(int n) {
		
		List<Move> moves = new ArrayList<>();
		moves.add(new Move(-1, -2));
		moves.add(new Move(-2, -1));
		moves.add(new Move(-2, 1));
		moves.add(new Move(-1, 2));
		moves.add(new Move(1,  2));
		moves.add(new Move(2, 1));
		moves.add(new Move(2, -1));
		moves.add(new Move(1, -2));
		
		int[][][] DP = new int[n][n][moves.size()];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				for(int k=0 ; k<DP[i][j].length ; k++)
					DP[i][j][k] = -1;
		
		int[][] results = new int[n][n];
		if(checkMove(n, 0, 0, results, moves, 1, 0, DP))
			showResult(results);
		else 
			System.out.println("Knight's tour is not possible on " + n + " x " + n + " board.");
	}
	
	private boolean checkMove(int n, int row, int col, int[][] results, List<Move> moves, int count, int currentMove, int[][][] DP) {
				
		if(count == (n*n)) {
			results[row][col] = count;
			return true;
		}
		
		if(DP[row][col][currentMove] != -1)
			return DP[row][col][currentMove] == 1;
		
		for(int k = 0 ; k < moves.size() ; k++) {

			Move move = moves.get(k);
			if(isValidMove(n, row, col, results, move)) {
				
				results[row][col] = count;
				if(checkMove(n, row + move.i, col + move.j, results, moves, count + 1, k + 1, DP)) {
					DP[k][row + move.i][col + move.j] = 1;
					return true; 
				} else {
					DP[k][row + move.i][col + move.j] = 0;
				}
			}
		}
		
		results[row][col] = 0;
		return false;
	}
	
	private boolean isValidMove(int n, int i, int j, int[][] results, Move move) {
		
		return (i + move.i >= 0 && j + move.j >= 0 && i + move.i < n && j + move.j < n && results[i + move.i][j + move.j] == 0); 
	}
	
	private static void showResult(int[][] results) {
		
		for(int[] a : results) {
			for(int b : a) {
				System.out.print(b + "\t");
			}
			System.out.println("\n\n\n");
		}
	}
	
	public static void main(String[] args) {
		
		int n = 8;
		
		KnightsTour kt = new KnightsTour();
		kt.tour(n);
	}
}
