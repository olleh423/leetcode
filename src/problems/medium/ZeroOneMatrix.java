package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ZeroOneMatrix {

    public static void main(String[] args) {

        ZeroOneMatrix obj = new ZeroOneMatrix();

        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = obj.updateMatrix(matrix);
        for(int[] A : result)
            System.out.println(Arrays.toString(A));
    }

    public int[][] updateMatrix(int[][] mat) {

        if(mat == null)
            return null;

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];

        for(int i = 0 ; i < rows ; i++) {

            for(int j = 0 ; j < cols ; j++) {

                if(mat[i][j] == 0)
                    result[i][j] = 0;
                else if(i == 0 && j == 0)
                    result[i][j] = Integer.MAX_VALUE;
                else if(i == 0)
                    result[i][j] = result[i][j-1] != Integer.MAX_VALUE ? 1 + result[i][j-1] : Integer.MAX_VALUE;
                else if(j == 0)
                    result[i][j] = result[i-1][j] != Integer.MAX_VALUE ? 1 + result[i-1][j] : Integer.MAX_VALUE;
                else
                    result[i][j] = Math.min(result[i-1][j], result[i][j-1]) != Integer.MAX_VALUE ? 1 + Math.min(result[i-1][j], result[i][j-1]) : Integer.MAX_VALUE;
            }
        }

        for(int i = rows - 1 ; i >= 0 ; i--) {

            for(int j = cols - 1 ; j >= 0 ; j--) {

                int current = result[i][j];

                if(mat[i][j] == 0)
                    result[i][j] = 0;
                else if(i == rows-1 && j < cols-1)
                    result[i][j] = Math.min(current, 1 + result[i][j+1]);
                else if(j == cols-1 && i < rows-1)
                    result[i][j] = Math.min(current, 1 + result[i+1][j]);
                else if(i != rows-1 && j != cols-1)
                    result[i][j] = Math.min(current, 1 + Math.min(result[i][j+1], result[i+1][j]));
            }
        }

        return result;
    }
}
