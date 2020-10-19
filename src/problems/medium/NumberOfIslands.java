package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class NumberOfIslands {

    public static void main(String[] args) {

        NumberOfIslands obj = new NumberOfIslands();

        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};

        System.out.println(obj.numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int totalIsland = 0;

        for(int i=0 ; i<grid.length ; i++) {

            for(int j=0 ; j<grid[i].length ; j++) {

                if(grid[i][j] == '1') {

                    totalIsland += dfs(grid, i, j, rows, cols);
                }
            }
        }

        return totalIsland;
    }

    private int dfs(char[][] grid, int i, int j, int rows, int cols) {

        if(i < 0 || i == rows || j < 0 || j == cols || grid[i][j] == '0')
            return 0;

        grid[i][j] = '0';

        dfs(grid, i+1, j, rows, cols);
        dfs(grid, i-1, j, rows, cols);
        dfs(grid, i, j+1, rows, cols);
        dfs(grid, i, j-1, rows, cols);

        return 1;
    }
}
