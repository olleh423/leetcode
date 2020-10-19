package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {

        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();

        int[][] cells = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(obj.shortestPathBinaryMatrix(cells));
    }

    private static class Cell {
        int i, j, dist;
        Cell(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int[] xMove = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] yMove = {-1, -1, -1, 0, 1, 1, 1, 0};

        return getMinPath(grid, xMove, yMove);
    }

    private static boolean isValid(int i, int j, int n, int[][] grid, boolean[][] visited) {

        return i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0 && !visited[i][j];
    }

    private int getMinPath(int[][] grid, int[] xMove, int[] yMove) {

        if(grid == null) return -1;

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int dist = Integer.MAX_VALUE;

        Queue<Cell> queue = new LinkedList<>();
        if(grid[0][0] == 0) {
            queue.add(new Cell(0, 0, 1));
            visited[0][0] = true;
        }

        while(!queue.isEmpty()) {

            Cell cell = queue.poll();
            if(cell.i == n-1 && cell.j == n-1) {
                dist = cell.dist;
                break;
            }

            for(int i=0 ; i < xMove.length ; i++) {
                if(isValid(cell.i + xMove[i], cell.j + yMove[i], n, grid, visited)) {
                    visited[cell.i + xMove[i]][cell.j + yMove[i]] = true;
                    queue.add(new Cell(cell.i + xMove[i], cell.j + yMove[i], cell.dist + 1));
                }
            }
        }

        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
}
