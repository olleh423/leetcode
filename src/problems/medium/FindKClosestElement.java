package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class FindKClosestElement {

    public static void main(String[] args) {

        FindKClosestElement obj = new FindKClosestElement();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int target = 3;

        System.out.println(obj.findClosestElements(arr, k, target));
    }

    private int findTargetIndex(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        while(low <= high) {

            int mid = (low + high) / 2;
            if(arr[mid] == target) return mid;

            if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int target) {

        List<Integer> result = new ArrayList<>();

        if(arr == null) return result;

        int idx = findTargetIndex(arr, target);
        int left = idx-1;
        int right = idx;

        while(k > 0) {

            if(left >= 0 && right < arr.length) {
                if(target - arr[left] > arr[right] - target) right++;
                else left--;
            }
            else if(left < 0)
                right++;
            else if(right >= arr.length)
                left--;

            k--;
        }

        for(int i=left+1 ; i<right ; i++)
            result.add(arr[i]);

        return result;
    }
}
