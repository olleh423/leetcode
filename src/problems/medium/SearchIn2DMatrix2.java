package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class SearchIn2DMatrix2 {

    public static void main(String[] args) {

        SearchIn2DMatrix2 obj = new SearchIn2DMatrix2();
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int i=0, j=matrix[0].length-1;

        while(i < matrix.length && j >= 0) {

            if(matrix[i][j] == target)
                return true;

            if(matrix[i][j] < target) i++;
            else j--;
        }

        return false;
    }
}
