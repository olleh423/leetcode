package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class PerfectSquares {

    public static void main(String[] args) {

        PerfectSquares obj = new PerfectSquares();
        int n = 12;
        System.out.println(obj.numSquares(n));
    }

    public int numSquares(int n) {

        int rows = (int) Math.sqrt(n);
        int[][] res = new int[rows][n+1];
        for(int i=0 ; i<res.length ; i++) {

            for(int j=1 ; j<res[i].length ; j++) {

                if(i == 0) {
                    res[i][j] = j;
                } else {

                    int sqre = (i+1)*(i+1);
                    if(j < sqre) {
                        res[i][j] = res[i-1][j];
                    } else {
                        int value = 1 + res[i][j - sqre];
                        res[i][j] = res[i-1][j] < value ? res[i-1][j] : value;
                    }
                }
            }
        }

        return res[rows-1][n];
    }
}
