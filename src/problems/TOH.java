package problems;
public class TOH {

	public static void main(String[] args) {
		int n = 3;
		moveDisc(n, "A", "B", "Temp");
	}

	public static void moveDisc(int n, String A, String B, String TEMP) {
		if (n == 0) {
			return;
		}
		moveDisc(n - 1, A, TEMP, B);
		System.out.println("Move disc " + n + " from " + A + " to rod " + B);
		moveDisc(n - 1, B, TEMP, A);
	}
}
