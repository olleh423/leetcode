package problems;

public class OverlappingRectangles {

	static class Axis {
		int x;
		int y;
		Axis(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "X : " + x + ", Y : " + y;
		}
	}
	
	public int getOverlappedArea(Axis oneBL, Axis oneTR, Axis twoBL, Axis twoTR) {
		
		Axis nBottomLeft = new Axis(Math.max(oneBL.x, twoBL.x), Math.max(oneBL.y, twoBL.y));
		Axis nTopRight = new Axis(Math.min(oneTR.x, twoTR.x), Math.min(oneTR.y, twoTR.y));
		
		int area = (nTopRight.x - nBottomLeft.x) * (nTopRight.y - nBottomLeft.y);
		
		return area;
	}
	
	public static void main(String... args) {
		
		Axis oneBL = new Axis(0, 0);
		Axis oneTR = new Axis(1, 1);
		Axis twoBL = new Axis(2, 2);
		Axis twoTR = new Axis(3, 3);
		
		OverlappingRectangles or = new OverlappingRectangles();
		
		System.out.println("Overlapped Area : " + or.getOverlappedArea(oneBL, oneTR, twoBL, twoTR)) ;
	}
}
