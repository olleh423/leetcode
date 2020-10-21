package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class RottingOranges {

    public static void main(String[] args) {

        RottingOranges obj = new RottingOranges();

        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(obj.orangesRotting(grid));
    }

    private class Orange {
        int x, y, dist;
        Orange(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private boolean isValid(int rows, int cols, int i, int j) {

        return !(i < 0 || i >= rows || j < 0 || j >= cols);
    }

    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0)
            return -1;

        int m = grid.length;
        int n = grid[0].length;

        Queue<Orange> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Orange(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int result = 0;
        while(!queue.isEmpty()) {

            Orange or = queue.poll();
            result = Math.max(result, or.dist);

            if(isValid(m, n, or.x - 1, or.y) && !visited[or.x - 1][or.y] && grid[or.x - 1][or.y] == 1) {
                queue.add(new Orange(or.x - 1, or.y, or.dist + 1));
                visited[or.x - 1][or.y] = true;
            }

            if(isValid(m, n, or.x + 1, or.y) && !visited[or.x + 1][or.y] && grid[or.x + 1][or.y] == 1) {
                queue.add(new Orange(or.x + 1, or.y, or.dist + 1));
                visited[or.x + 1][or.y] = true;
            }

            if(isValid(m, n, or.x, or.y - 1) && !visited[or.x][or.y - 1] && grid[or.x][or.y - 1] == 1) {
                queue.add(new Orange(or.x, or.y - 1, or.dist + 1));
                visited[or.x][or.y - 1] = true;
            }

            if(isValid(m, n, or.x, or.y + 1) && !visited[or.x][or.y + 1] && grid[or.x][or.y + 1] == 1) {
                queue.add(new Orange(or.x, or.y + 1, or.dist + 1));
                visited[or.x][or.y + 1] = true;
            }
        }

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == 1 && !visited[i][j])
                    return -1;
            }
        }

        return result;
    }
}
