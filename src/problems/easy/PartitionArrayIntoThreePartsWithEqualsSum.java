package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class PartitionArrayIntoThreePartsWithEqualsSum {

    public static void main(String[] args) {

        PartitionArrayIntoThreePartsWithEqualsSum obj = new PartitionArrayIntoThreePartsWithEqualsSum();

        int[] A = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        System.out.println(obj.canThreePartsEqualSum(A));
    }

    public boolean canThreePartsEqualSum(int[] A) {

        if(A == null) return false;

        int total = 0;
        for(int a : A) total += a;

        if(total % 3 != 0) return false;
        total /= 3;

        int runningSum = 0;
        int count = 0;

        for(int i=0 ; i<A.length ; i++) {
            runningSum += A[i];
            if(runningSum == total) {
                count++;
                runningSum = 0;
            }
        }

        return count >= 3;
    }
}
