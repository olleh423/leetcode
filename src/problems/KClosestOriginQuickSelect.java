package problems;

public class KClosestOriginQuickSelect {

	private static class Point {
		int i, j, d;
		Point(int i, int j) {
			this.i = i;
			this.j = j;
			this.d = (i*i) + (j*j);
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	private static void solve(int[][] points, int k) {
		
		Point[] arr = new Point[points.length];
		for(int i=0 ; i<points.length ; i++) {
			arr[i] = new Point(points[i][0], points[i][1]);
		}
		
		
	}
}
