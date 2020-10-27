package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ReplaceElementWithGreatestElementOnRight {

    public static void main(String[] args) {

        ReplaceElementWithGreatestElementOnRight obj = new ReplaceElementWithGreatestElementOnRight();
    }

    public int[] replaceElements(int[] arr) {

        if(arr == null || arr.length < 1)
            return arr;

        int n = arr.length - 1;
        int max = arr[n];
        arr[n] = -1;

        for(int i=n-1 ; i>=0 ; i--) {

            if(arr[i] > max) {
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            }
            else
                arr[i] = max;
        }

        return arr;
    }
}
