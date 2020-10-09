package problems;
import java.util.ArrayList;
import java.util.List;

public class N_Queen {

	public static void main(String[] args) {

		int n = 8;

		List<Positions> positions = getPositions(n);
		
		int[][] board = new int[n][n];
		for (Positions p : positions) {
			board[p.row][p.col] = 1;
		}

		for (int[] row : board) {
			for (int col : row) {
				System.out.print(col == 1 ? "X " : col + " ");
			}
			System.out.println();
		}
	}


	private static List<Positions> getPositions(int n) {

		List<Positions> pos = new ArrayList<>(n);
		return getPositions(0, 0, pos, n);
	}


	private static List<Positions> getPositions(int r, int c, List<Positions> pos, int n) {

		if (r == n || c == n)
			return pos;

		if (isSafe(r, c, pos)) {

			pos.add(r, new Positions(r, c));

			pos = getPositions(r + 1, 0, pos, n);

			if (pos.size() < n) {
				pos.remove(r);
				pos = getPositions(r, c + 1, pos, n);
			}
			return pos;

		} else
			return getPositions(r, c + 1, pos, n);
	}


	private static boolean isSafe(int row, int col, List<Positions> positions) {

		for (Positions p : positions) {
			if (p != null) {
				if ((p.row == row || p.col == col || p.row - p.col == row - col || p.row
						+ p.col == row + col))
					return false;
			}
		}
		return true;
	}

	
	static class Positions {

		int row, col;

		Positions(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "[ " + row + ", " + col + " ]";
		}
	}
}
