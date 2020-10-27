package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class TwoSumLessThanK {

    public static void main(String[] args) {

        TwoSumLessThanK obj = new TwoSumLessThanK();
    }

    public int twoSumLessThanK(int[] A, int K) {

        if(A == null) return 0;

        Arrays.sort(A);
        int res = Integer.MIN_VALUE;
        int i=0, j=A.length-1;

        while(i < j) {
            int sum = A[i] + A[j];
            if(sum < K)
                res = Math.max(res, sum);

            if(sum < K) i++;
            else j--;
        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
