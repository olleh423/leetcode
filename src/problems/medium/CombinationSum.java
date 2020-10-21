package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum obj = new CombinationSum();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        solve(candidates, 0, target, new ArrayList<Integer>(), result);

        return result;
    }

    private void solve(int[] arr, int i, int n, List<Integer> data, List<List<Integer>> result) {

        if(n == 0) {
            result.add(new ArrayList<Integer>(data));
            return;
        }

        if(n < 0 || i == arr.length)
            return;

        data.add(arr[i]);
        solve(arr, i, n-arr[i], data, result);

        data.remove(data.size()-1);
        solve(arr, i+1, n, data, result);
    }
}
