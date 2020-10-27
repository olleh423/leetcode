package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class PeekIndexInMountainArray {

    public static void main(String[] args) {

        PeekIndexInMountainArray obj = new PeekIndexInMountainArray();
    }

    public int peakIndexInMountainArray(int[] arr) {

        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return mid;
            if(arr[mid] > arr[mid-1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
