package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class PathWithMaximumGold {

    public static void main(String[] args) {

        PathWithMaximumGold obj = new PathWithMaximumGold();
    }

    public int getMaximumGold(int[][] grid) {

        if(grid == null)
            return 0;

        int result = Integer.MIN_VALUE;
        for(int i=0 ; i<grid.length ; i++) {
            for(int j=0 ; j<grid[i].length ; j++) {
                if(grid[i][j] != 0) {

                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int maxGoldFromHere = explore(i, j, grid, visited);
                    result = result < maxGoldFromHere ? maxGoldFromHere : result;
                }
            }
        }

        return result;
    }

    private int explore(int i, int j, int[][] grid, boolean[][] visited) {

        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || visited[i][j])
            return 0;

        visited[i][j] = true;

        int fromTop = explore(i-1, j, grid, visited);
        int fromBottom = explore(i+1, j, grid, visited);
        int fromLeft = explore(i, j-1, grid, visited);
        int fromRight = explore(i, j+1, grid, visited);

        int max = grid[i][j] + max(fromTop, max(fromBottom, max(fromLeft, fromRight)));

        visited[i][j] = false;
        return max;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
