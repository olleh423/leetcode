package problems.medium;

import java.util.*;
/*
 * Author : Vijay Sharma 18-10-2020
 */
public class Flatten2DVector {

    public static void main(String[] args) {

        Flatten2DVector obj = new Flatten2DVector();

        int[][] elements = {{1,2,3},{2,5},{1},{3,6,9,8}};

        Vector2D iterator = new Vector2D(elements);
        iterator.next(); // return 1
        iterator.next(); // return 2
        iterator.next(); // return 3
        iterator.hasNext(); // return true
        iterator.hasNext(); // return true
        iterator.next(); // return 4
        iterator.hasNext(); // return false
    }

    private static class Vector2D {

        private int size = 0;
        private Queue<Integer> queue;

        public Vector2D(int[][] v) {
            queue = new LinkedList<>();
            extract(v);
        }

        private void extract(int[][] v) {
            for(int i=0 ; i<v.length ; i++) {
                for(int j=0 ; j<v[i].length ; j++) {
                    queue.add(v[i][j]);
                }
            }
            size = queue.size();
        }

        public int next() {
            size--;
            return queue.poll();
        }

        public boolean hasNext() {
            return size > 0;
        }
    }
}
