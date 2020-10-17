package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class MaximalSquare {

    public static void main(String[] args) {

        MaximalSquare obj = new MaximalSquare();
    }

    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0)
            return 0;

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] DP = new int[r][c];
        int max = 0;

        for(int i=0 ; i<DP.length ; i++) {

            for(int j=0 ; j<DP[i].length ; j++) {

                if(i == 0 || j == 0) {
                    DP[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
                else if(matrix[i][j] == '1') {

                    int T = i == 0 ? Integer.MAX_VALUE : DP[i-1][j];
                    int L = j == 0 ? Integer.MAX_VALUE : DP[i][j-1];
                    int D = i > 0 && j > 0 ? DP[i-1][j-1] : Integer.MAX_VALUE;

                    DP[i][j] = 1 + Math.min(T, Math.min(L, D));
                }
                max = Math.max(max, DP[i][j]);
            }
        }

        return max * max;
    }
}
