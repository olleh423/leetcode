package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class PascalsTriangle2 {

    public static void main(String[] args) {

        PascalsTriangle2 obj = new PascalsTriangle2();

        int rowIndex = 7;
        System.out.println(obj.getRow(rowIndex));
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<=rowIndex ; i++) {

            List<Integer> row = new ArrayList<>();
            for(int j=0 ; j<=i ; j++) {

                if(j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    int value = result.get(j) + result.get(j-1);
                    row.add(value);
                }
            }

            result = new ArrayList<>(row);
        }

        return result;
    }
}
