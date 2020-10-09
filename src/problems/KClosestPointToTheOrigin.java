package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToTheOrigin {

	public static class Point {
        
        private int i;
        private int j;
        private int digonalSqr;
        
        Point(int i, int j) {
            this.i = i;
            this.j = j;
            this.digonalSqr = (i*i) + (j*j);
        }
    }

	public int[][] kClosest(int[][] points, int k) {
        
        int[][] result = new int[k][k];
        
        if(points == null || points.length == 0 || k == 0)
            return result;
        
        PriorityQueue<Point> minHeap = new PriorityQueue<>(
            new Comparator<Point>() {
                @Override
                public int compare(Point one, Point two) {
                    return new Integer(one.digonalSqr).compareTo(new Integer(two.digonalSqr));
                }
            }
        );
        
        for(int i=0 ; i<points.length ; i++) {
            minHeap.add(new Point(points[i][0], points[i][1]));
        }
        
        for(int i=0 ; i<k ; i++) {
            Point min = minHeap.remove();
            result[i] = new int[]{min.i, min.j};
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		
		int[][] points = {{1,3},{-2,2}};
		int k = 1;
		
		KClosestPointToTheOrigin obj = new KClosestPointToTheOrigin();
		
		int[][] results = obj.kClosest(points, k);
		
		for(int[] row : results) {
			System.out.println(row[0] + " - " + row[1]);
		}
	}
}
