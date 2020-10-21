package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {

        FindAllDuplicatesInAnArray obj = new FindAllDuplicatesInAnArray();
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(obj.findDuplicates(arr));
    }

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        if(nums == null)
            return result;

        for(int i=0 ; i<nums.length ; i++) {

            if(nums[Math.abs(nums[i])-1] > 0)
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            else
                result.add(Math.abs(nums[i]));
        }

        return result;
    }
}
