package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 18-10-2020
 */
public class UniquePaths {

    public static void main(String[] args) {

        UniquePaths obj = new UniquePaths();

        int m = 4;
        int n = 6;
        System.out.println(obj.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {

        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;

        int[][] grid = new int[m][n];
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++)
                grid[i][j] = i == 0 || j == 0 ? 1 : grid[i-1][j] + grid[i][j-1];
        }

        return grid[m-1][n-1];
    }
}
