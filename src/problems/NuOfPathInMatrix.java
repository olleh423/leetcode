package problems;

public class NuOfPathInMatrix {
	
	private static int getPath(int i, int j, int R, int C) {
		
		if(i == R && j == C) return 1;
		if(i > R || j > C) return 0;
		
		return getPath(i+1, j, R, C) + getPath(i, j+1, R, C);
	}
	
	public static int getNumberOfPath(int row, int col) {
		
		return getPath(0, 0, row-1, col-1);
	}

	public static void main(String[] args) {
		
		int row = 3;
		int col = 5;
		
		System.out.println(getNumberOfPath(row, col));
	}
}
