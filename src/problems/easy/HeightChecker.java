package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class HeightChecker {

    public static void main(String[] args) {

        HeightChecker obj = new HeightChecker();

        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(obj.heightChecker(heights));
    }

    public int heightChecker(int[] heights) {

        if(heights == null || heights.length == 0)
            return 0;

        int[] sorted = new int[heights.length];
        for(int i=0 ; i<heights.length ; i++) {
            sorted[i] = heights[i];
        }

        Arrays.sort(sorted);

        int mismatched = 0;
        for(int i=0 ; i<sorted.length ; i++) {
            if(sorted[i] != heights[i])
                mismatched++;
        }

        return mismatched;
    }
}
