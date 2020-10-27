package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FlippingAnImage {

    public static void main(String[] args) {

        FlippingAnImage obj = new FlippingAnImage();
    }

    public int[][] flipAndInvertImage(int[][] A) {

        for(int i=0 ; i<A.length ; i++) {

            int s = 0, e = A[i].length-1;

            while(s < e) {
                int temp = A[i][s];
                A[i][s] = A[i][e];
                A[i][e] = temp;

                s++;
                e--;
            }
        }

        for(int i=0 ; i<A.length ; i++) {
            for(int j=0 ; j<A[i].length ; j++) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }

        return A;
    }
}
