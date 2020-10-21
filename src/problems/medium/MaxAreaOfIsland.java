package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {

        MaxAreaOfIsland obj = new MaxAreaOfIsland();
    }

    public int maxAreaOfIsland(int[][] grid) {

        if(grid == null || grid.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;

        for(int i=0 ; i<grid.length ; i++) {
            for(int j=0 ; j<grid[i].length ; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, exploreIsland(grid, i, j));
                }
            }
        }

        return max != Integer.MIN_VALUE ? max : 0;
    }

    private int exploreIsland(int[][] grid, int i, int j) {

        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] != 1)
            return 0;

        grid[i][j] = 0;

        int size = 1;

        size += exploreIsland(grid, i+1, j);
        size += exploreIsland(grid, i-1, j);
        size += exploreIsland(grid, i, j+1);
        size += exploreIsland(grid, i, j-1);

        return size;
    }
}
