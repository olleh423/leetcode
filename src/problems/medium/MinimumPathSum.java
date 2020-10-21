package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class MinimumPathSum {

    public static void main(String[] args) {

        MinimumPathSum obj = new MinimumPathSum();
    }

    public int minPathSum(int[][] grid) {

        if(grid == null)
            return 0;

        int n = grid.length;
        int m = n == 0 ? 0 : grid[0].length;

        if(n == 0 || m == 0)
            return 0;

        for(int i=1 ; i<n ; i++)
            grid[i][0] = grid[i][0] + grid[i-1][0];

        for(int i=1 ; i<m ; i++)
            grid[0][i] = grid[0][i] + grid[0][i-1];

        for(int i=1 ; i<n ; i++) {
            for(int j=1 ; j<m ; j++) {
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }

        return grid[n-1][m-1];
    }
}
