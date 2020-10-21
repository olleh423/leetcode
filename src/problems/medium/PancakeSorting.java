package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class PancakeSorting {

    public static void main(String[] args) {

        PancakeSorting obj = new PancakeSorting();
        int[] arr = {3,2,4,1};
        System.out.println(obj.pancakeSort(arr));
    }

    public List<Integer> pancakeSort(int[] A) {

        List<Integer> result = new ArrayList<>();
        if(A == null)
            return result;

        int low=0, high=A.length-1;
        while(low <= high) {

            int maxIndex = getMaxIndexFromRange(A, low, high);
            if(maxIndex == high) {
                high--;
            }
            else {
                reverse(A, low, maxIndex);
                reverse(A, low, high);
                result.add(maxIndex+1);
                result.add(high+1);
                high--;
            }
        }

        return result;
    }

    private void reverse(int[] A, int i, int j) {

        while(i <= j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++; j--;
        }
    }

    private int getMaxIndexFromRange(int[] A, int i, int j) {
        int index = i;
        int max = A[i];
        for(int k=i+1 ; k<=j ; k++) {
            if(max < A[k]) {
                max = A[k];
                index = k;
            }
        }
        return index;
    }
}
