package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class PascalsTriangle {

    public static void main(String[] args) {

        PascalsTriangle obj = new PascalsTriangle();
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;

        for(int i=0 ; i<numRows ; i++) {

            List<Integer> row = new ArrayList<>();
            for(int j=0 ; j<=i ; j++) {

                if(j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    int value = result.get(i-1).get(j) + result.get(i-1).get(j-1);
                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }
}
