package problems.hard;

import java.util.*;

/*
 * Author : Vijay Sharma 02-02-2021
 */
public class TrappingRainWater_2 {

    public static void main(String[] args) {

        TrappingRainWater_2 obj = new TrappingRainWater_2();

        int[][] heightMap = {{12, 13, 1, 12},
                             {13, 4, 13, 12},
                             {13, 8, 10, 12},
                             {12, 13, 12, 12},
                             {13, 13, 13, 13}};

        System.out.println(obj.trapRainWater(heightMap));
    }

    private static class Cell {
        int i, j, height;
        Cell(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {

        if(heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));

        int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for(int i=0 ; i<n ; i++) {
            visited[i][0] = true;
            visited[i][m-1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, m-1, heights[i][m-1]));
        }

        for(int i=1 ; i<m-1 ; i++) {
            visited[0][i] = true;
            visited[n-1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(n-1, i, heights[n-1][i]));
        }

        int result = 0;

        while(!queue.isEmpty()) {

            Cell cell = queue.poll();
            for(int[] move : moves) {

                int new_i = cell.i + move[0];
                int new_j = cell.j + move[1];

                if(isValid(cell, new_i, new_j, visited, heights)) {

                    if(cell.height > heights[new_i][new_j]) {
                        result += cell.height - heights[new_i][new_j];
                        heights[new_i][new_j] = cell.height;
                    }
                    visited[new_i][new_j] = true;
                    queue.offer(new Cell(new_i, new_j, heights[new_i][new_j]));
                }
            }
        }

        return result;
    }

    private boolean isValid(Cell cell, int new_i, int new_j, boolean[][] visited, int[][] heights) {
        return !(new_i < 0 || new_i >= heights.length ||
                new_j < 0 || new_j >= heights[0].length ||
                visited[new_i][new_j]);
    }
}
