package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class IslandParimeter {

    public static void main(String[] args) {

        IslandParimeter obj = new IslandParimeter();

        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(obj.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {

        if(grid == null) return 0;

        int perimeter = 0;
        for(int i=0 ; i<grid.length ; i++) {
            for(int j=0 ; j<grid[i].length ; j++) {
                if(grid[i][j] == 1) {
                    perimeter += i-1 < 0 ? 1 : grid[i-1][j] == 0 ? 1 : 0;
                    perimeter += j+1 >= grid[i].length ? 1 : grid[i][j+1] == 0 ? 1 : 0;
                    perimeter += i+1 >= grid.length ? 1 : grid[i+1][j] == 0 ? 1 : 0;
                    perimeter += j-1 < 0 ? 1 : grid[i][j-1] == 0 ? 1 : 0;
                }
            }
        }

        return perimeter;
    }
}
