package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class Subsets {

    public static void main(String[] args) {

        Subsets obj = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(obj.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums == null)
            return result;

        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void subsets(int[] nums, int idx, List<Integer> set, List<List<Integer>> result) {

        if(idx == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }

        subsets(nums, idx+1, set, result);
        set.add(nums[idx]);
        subsets(nums, idx+1, set, result);
        set.remove(set.size() - 1);
    }
}
