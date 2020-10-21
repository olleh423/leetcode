package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class RotateImage {

    public static void main(String[] args) {

        RotateImage obj = new RotateImage();
    }

    public void rotate(int[][] M) {

        int last = M.length - 1;
        int totalLevels = M.length / 2;
        int level = 0;

        while(level < totalLevels) {

            for(int i=level ; i<last ; i++) {

                swap(M, level, i, i, last);
                swap(M, level, i, last, last-i+level);
                swap(M, level, i, last-i+level, level);
            }

            level++;
            last--;
        }
    }

    private void swap(int[][] grid, int si, int sj, int di, int dj) {

        int temp = grid[si][sj];
        grid[si][sj] = grid[di][dj];
        grid[di][dj] = temp;
    }
}
