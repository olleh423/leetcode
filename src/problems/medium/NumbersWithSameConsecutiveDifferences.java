package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class NumbersWithSameConsecutiveDifferences {

    public static void main(String[] args) {

        NumbersWithSameConsecutiveDifferences obj = new NumbersWithSameConsecutiveDifferences();
        int n = 3, k = 7;
        System.out.println(Arrays.toString(obj.numsSameConsecDiff(n, k)));
    }

    public int[] numsSameConsecDiff(int N, int K) {

        if(N == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> result = new ArrayList<>();
        for(int i=1 ; i<=9 ; i++)
            solve(N, K, i, 0, i, result);

        int[] arr = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++)
            arr[i] = result.get(i);

        return arr;
    }

    private void solve(int n, int k, int curr, int i, int prev, List<Integer> result) {

        if(i == n - 1) {
            result.add(curr);
            return;
        }

        int next = prev + k;
        if(next < 10) {
            solve(n, k, curr * 10 + next, i+1, next, result);
        }
        next = prev - k;
        if(k != 0 && next >= 0) {
            solve(n, k, curr * 10 + next, i+1, next, result);
        }
    }
}
