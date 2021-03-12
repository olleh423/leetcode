package problems.medium;/*
 * Author : Vijay Sharma 11-03-2021
 */

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {

        LargestNumber obj = new LargestNumber();

        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(obj.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {

        if(nums == null) return null;

        Integer[] sorted = new Integer[nums.length];
        for(int i=0 ; i<nums.length ; i++) {
            sorted[i] = new Integer(nums[i]);
        }

        Arrays.sort(sorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                String s1 = one + "" + two;
                String s2 = two + "" + one;
                return s2.compareTo(s1);
            }
        });

        StringBuilder builder = new StringBuilder();
        boolean leadingZeros = true;
        for(int n : sorted) {
            if(n != 0 || !leadingZeros)
                builder.append(n);
            if(n != 0)
                leadingZeros = false;
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}
