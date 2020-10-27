package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SortArrayByPairity {

    public static void main(String[] args) {

        SortArrayByPairity obj = new SortArrayByPairity();
    }

    public int[] sortArrayByParity(int[] A) {

        if(A == null)
            return null;

        int i=0; int j=A.length-1;
        while(i < j) {
            if(A[i] % 2 == 1) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j--;
            }
            else {
                i++;
            }
        }

        return A;
    }
}
