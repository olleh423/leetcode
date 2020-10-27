package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class IntersectionOfTwoArrays_2 {

    public static void main(String[] args) {

        IntersectionOfTwoArrays_2 obj = new IntersectionOfTwoArrays_2();

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(obj.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] A, int[] B) {

        if(A == null || B == null) return null;

        if(A.length > B.length) return intersect(B, A);

        Map<Integer, Integer> fA = new HashMap<>();
        Map<Integer, Integer> fB = new HashMap<>();

        for(int i=0 ; i<A.length ; i++)
            fA.put(A[i], 1 + fA.getOrDefault(A[i], 0));

        for(int i=0 ; i<B.length ; i++)
            fB.put(B[i], 1 + fB.getOrDefault(B[i], 0));

        List<Integer> result = new ArrayList<>();
        for(int key : fA.keySet()) {
            if(fB.containsKey(key)) {
                for(int k=0 ; k<Math.min(fA.get(key), fB.get(key)) ; k++) {
                    result.add(key);
                }
            }
        }

        int[] res = new int[result.size()];
        for(int i=0 ; i<res.length ; i++)
            res[i] = result.get(i);

        return res;
    }
}
