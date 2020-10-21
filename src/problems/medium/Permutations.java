package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class Permutations {

    public static void main(String[] args) {

        Permutations obj = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = obj.permute(nums);
        for(List<Integer> row : result)
            System.out.println(row);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        permute(nums, 0, result);
        return result;
    }

    private void permute(int[] data, int i, List<List<Integer>> result) {

        if(i == data.length - 1) {
            List<Integer> row = new ArrayList<>();
            for(int n : data) row.add(n);
            result.add(row);
            return;
        }

        for(int k=i ; k<data.length ; k++) {
            swap(i, k, data);
            permute(data, i+1, result);
            swap(i, k, data);
        }
    }

    private void swap(int i, int j, int[] data) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
