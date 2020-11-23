package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 23-11-2020
 */
public class MaximumSumOfArrayAfterKNegation {

    public static void main(String[] args) {

        MaximumSumOfArrayAfterKNegation obj = new MaximumSumOfArrayAfterKNegation();

        int[] A = {4, 2, 3};
        int K = 1;
        System.out.println(obj.largestSumAfterKNegations(A, K));
    }

    public int largestSumAfterKNegations(int[] A, int K) {

        if(A == null) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : A) minHeap.add(n);

        while(K-- > 0) {
            int min = minHeap.remove();
            minHeap.add(min * -1);
        }

        int total = 0;
        while(!minHeap.isEmpty()) {
            total += minHeap.remove();
        }

        return total;
    }
}
