package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ConbinationalSum2 {

    public static void main(String[] args) {

        ConbinationalSum2 obj = new ConbinationalSum2();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void solve(int[] arr, int index, int n, List<Integer> data, List<List<Integer>> result) {

        if(n == 0) {
            result.add(new ArrayList<Integer>(data));
            return;
        }

        if(n < 0)
            return;

        for(int i=index ; i<arr.length ; i++) {

            if(i == index || arr[i] != arr[i-1]) {

                data.add(arr[i]);
                solve(arr, i+1, n-arr[i], data, result);
                data.remove(data.size()-1);
            }
        }
    }
}
