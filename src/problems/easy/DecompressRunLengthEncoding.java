package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DecompressRunLengthEncoding {

    public static void main(String[] args) {

        DecompressRunLengthEncoding obj = new DecompressRunLengthEncoding();
    }

    public int[] decompressRLElist(int[] nums) {

        if(nums == null)
            return null;

        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i+=2) {
            for(int j=0 ; j<nums[i] ; j++) {
                result.add(nums[i+1]);
            }
        }

        int[] arr = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}
