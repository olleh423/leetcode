package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FindAllNumberDisappearedInAnArray {

    public static void main(String[] args) {

        FindAllNumberDisappearedInAnArray obj = new FindAllNumberDisappearedInAnArray();
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if(nums == null)
            return result;

        for(int i=0 ; i<nums.length ; i++) {
            int v = Math.abs(nums[i]);
            if(nums[v-1] > 0)
                nums[v-1] *= -1;
        }

        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] > 0) result.add(i+1);
        }

        return result;
    }
}
