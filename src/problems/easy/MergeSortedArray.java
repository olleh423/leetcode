package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        MergeSortedArray obj = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        obj.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums1 == null || nums2 == null)
            return;

        int end = nums1.length - 1; m--; n--;

        while(m >= 0 || n >= 0) {

            int one = m < 0 ? Integer.MIN_VALUE : nums1[m];
            int two = n < 0 ? Integer.MIN_VALUE : nums2[n];

            if(one > two) {
                nums1[end] = one;
                m--;
            } else {
                nums1[end] = two;
                n--;
            }
            end--;
        }
    }
}
