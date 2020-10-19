package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class Triangle {

    public static void main(String[] args) {

        Triangle obj = new Triangle();

        int[][] arr = {      {2},
                           {3, 4},
                          {6, 5, 7},
                         {4, 1, 8, 3}   };
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        for(int i = triangle.size()-2 ; i >= 0 ; i--) {
            List<Integer> parent = triangle.get(i);
            List<Integer> child = triangle.get(i+1);
            for(int j=0 ; j<parent.size() ; j++) {
                parent.set(j, parent.get(j) + Integer.min(child.get(j), child.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
