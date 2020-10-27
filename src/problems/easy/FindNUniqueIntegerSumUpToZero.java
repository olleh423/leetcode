package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FindNUniqueIntegerSumUpToZero {

    public static void main(String[] args) {

        FindNUniqueIntegerSumUpToZero obj = new FindNUniqueIntegerSumUpToZero();
    }

    public int[] sumZero(int n) {

        int total = 0;
        int[] arr = new int[n];
        for(int i=0 ; i<n-1 ; i++) {
            arr[i] = i+1;
            total += arr[i];
        }
        arr[n-1] = -total;
        return arr;
    }
}
