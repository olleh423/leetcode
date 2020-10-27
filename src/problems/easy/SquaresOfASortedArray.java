package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {

        SquaresOfASortedArray obj = new SquaresOfASortedArray();
    }

    private int firstPositiveIndex(int[] arr) {

        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i] >= 0) return i;
        }
        return arr.length;
    }

    public int[] sortedSquares(int[] arr) {

        if(arr == null)
            return null;

        int[] result = new int[arr.length];

        int i = firstPositiveIndex(arr);
        int j = i-1;
        int k = 0;
        while(j >= 0 || i < arr.length) {

            if(j >= 0 && i < arr.length) {
                if(arr[j] * arr[j] > arr[i] * arr[i]) {
                    result[k++] = arr[i] * arr[i];
                    i++;
                } else {
                    result[k++] = arr[j] * arr[j];
                    j--;
                }
            }
            else if(j < 0) {
                result[k++] = arr[i] * arr[i];
                i++;
            }
            else if(i == arr.length) {
                result[k++] = arr[j] * arr[j];
                j--;
            }
        }

        return result;
    }
}
