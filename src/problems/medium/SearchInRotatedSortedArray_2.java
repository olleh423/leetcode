package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 29-10-2020
 */
public class SearchInRotatedSortedArray_2 {

    public static void main(String[] args) {

        SearchInRotatedSortedArray_2 obj = new SearchInRotatedSortedArray_2();
    }

    public boolean search(int[] arr, int target) {

        if(arr == null || arr.length == 0) return false;

        return search(arr, target, 0, arr.length - 1);
    }

    private boolean search(int[] arr, int target, int i, int j) {

        if(i > j) return false;

        int mid = (i + j) / 2;

        if(arr[mid] == target) return true;

        if(arr[i] == arr[mid] && arr[j] == arr[mid])
            return search(arr, target, i, mid - 1) || search(arr, target, mid + 1, j);

        if(arr[i] == arr[mid]) return search(arr, target, mid+1, j);
        if(arr[j] == arr[mid]) return search(arr, target, i, mid-1);

        boolean isLeftSorted = arr[i] < arr[mid];
        if(isLeftSorted) {
            if(arr[i] <= target && arr[mid] > target) return search(arr, target, i, mid-1);
            else return search(arr, target, mid+1, j);
        }
        else {
            if(arr[mid] < target && arr[j] >= target) return search(arr, target, mid+1, j);
            else return search(arr, target, i, mid-1);
        }
    }
}
