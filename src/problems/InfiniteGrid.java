package problems;

public class InfiniteGrid {

	public static int min(int a, int b, int c) {

		return a < b ? a < c ? a : c : b < c ? b : c;
	}
	
	public static int getMinStep(int Si, int Sj, int Di, int Dj) {
		
		int min = Math.abs(Si - Di) - 1;
		min += min(Math.abs(Sj - min - Dj), Math.abs(Sj - Dj), Math.abs(Sj + min - Dj));
		return min;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getMinStep(-5, -4, 3, -1));
	}
}
