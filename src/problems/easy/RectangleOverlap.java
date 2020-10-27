package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RectangleOverlap {

    public static void main(String[] args) {

        RectangleOverlap obj = new RectangleOverlap();
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return rec1[0] < rec2[2] && rec1[1] < rec2[3]
                && rec1[2] > rec2[0] && rec1[3] > rec2[1];
    }
}
