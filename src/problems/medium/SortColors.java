package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class SortColors {

    public static void main(String[] args) {

        SortColors obj = new SortColors();
        int[] arr = {1, 1, 2, 0, 1, 2, 0, 0, 2, 1, 0, 1, 2, 2, 0};
        obj.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] arr) {

        if(arr == null) return;

        int low = 0, high = arr.length - 1;
        int i=0;
        while(i <= high) {

            if(arr[i] == 0) {
                swap(i, low, arr);
                low++; i++;
            }
            else if(arr[i] == 2) {
                swap(i, high, arr);
                high--;
            }
            else {
                i++;
            }
        }
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
