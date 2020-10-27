package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MonotonicArray {

    public static void main(String[] args) {

        MonotonicArray obj = new MonotonicArray();
    }

    public boolean isMonotonic(int[] arr) {

        if(arr == null) return false;

        boolean A = true, B = true;

        // check non decreasing
        for(int i=1 ; i<arr.length ; i++) {
            if(arr[i] < arr[i-1]) {
                A = false;
                break;
            }
        }

        if(A) return true;

        // check non decreasing
        for(int i=1 ; i<arr.length ; i++) {
            if(arr[i] > arr[i-1]) {
                B = false;
                break;
            }
        }

        return A || B;
    }
}
