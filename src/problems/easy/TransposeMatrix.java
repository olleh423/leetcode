package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class TransposeMatrix {

    public static void main(String[] args) {

        TransposeMatrix obj = new TransposeMatrix();
    }

    public int[][] transpose(int[][] A) {

        if(A == null || A.length == 0)
            return null;

        int rows = A.length;
        int cols = A[0].length;

        int[][] mat = new int[cols][rows];
        for(int i=0 ; i<A.length ; i++) {
            for(int j=0 ; j<A[i].length ; j++) {
                mat[j][i] = A[i][j];
            }
        }

        return mat;
    }
}
