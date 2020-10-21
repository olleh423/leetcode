package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class MaxConsecutiveOnes3 {

    public static void main(String[] args) {

        MaxConsecutiveOnes3 obj = new MaxConsecutiveOnes3();
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;
        System.out.println(obj.longestOnes(A, K));
    }

    public int longestOnes(int[] arr, int k) {

        int j=0, c=0;
        int max = 0;

        for(int i=0 ; i<arr.length ; i++) {

            if(arr[i] == 0)
                c++;

            while(c > k) {
                if(arr[j] == 0)
                    c--;
                j++;
            }

            max = Math.max(max, i-j+1);
        }

        return max;
    }
}
