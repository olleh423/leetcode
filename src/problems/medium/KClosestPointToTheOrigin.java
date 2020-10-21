package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class KClosestPointToTheOrigin {

    public static void main(String[] args) {

        KClosestPointToTheOrigin obj = new KClosestPointToTheOrigin();
    }

    public int[][] kClosest(int[][] points, int k) {

        int[][] result = new int[k][k];

        if(points == null || points.length == 0 || k == 0)
            return result;

        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.digonalSqr, a.digonalSqr));

        for(int i=0 ; i<points.length ; i++) {

            Point p = new Point(points[i][0], points[i][1]);

            if(maxHeap.size() < k) {
                maxHeap.add(p);
            }
            else if(maxHeap.peek().digonalSqr > p.digonalSqr) {
                maxHeap.poll();
                maxHeap.add(p);
            }
        }

        for(int i=0 ; i<k ; i++) {
            Point min = maxHeap.remove();
            result[i] = new int[]{min.i, min.j};
        }

        return result;
    }

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
}
