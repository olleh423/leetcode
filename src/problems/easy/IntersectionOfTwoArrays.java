package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        int i=0, j=0;
        while(i < nums1.length && j < nums2.length) {

            if(nums1[i] == nums2[j] && !set.contains(nums1[i])) {
                res.add(nums1[i]);
                set.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        int[] arr = new int[res.size()];
        for(int k=0 ; k<res.size() ; k++)
            arr[k] = res.get(k);

        return arr;
    }
}
