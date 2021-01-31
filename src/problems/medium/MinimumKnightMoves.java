package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 30-01-2021
 */
public class MinimumKnightMoves {

    public static void main(String[] args) {

        MinimumKnightMoves obj = new MinimumKnightMoves();

        int x = 19;
        int y = 45;
        System.out.println(obj.minKnightMoves(x, y));
    }

    public int minKnightMoves(int x, int y) {

        x = Math.abs(x);
        y = Math.abs(y);

        int[][] moves = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};

        Set<String> visited = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        int minMoves = 0;
        while(!queue.isEmpty()) {

            int len = queue.size();
            for(int k=0 ; k<len ; k++) {

                Point point = queue.poll();
                if(point.x == x && point.y == y)
                    return minMoves;

                for(int i=0 ; i<moves.length ; i++) {

                    int newX = point.x + moves[i][0];
                    int newY = point.y + moves[i][1];

                    String key = newX + "-" + newY;
                    if(!visited.contains(key) && newX >= -2 && newY >= -2) {
                        visited.add(key);
                        queue.add(new Point(newX, newY));
                    }
                }
            }

            minMoves += 1;
        }
        return minMoves;
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
