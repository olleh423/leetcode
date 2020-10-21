package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class CountingBits {

    public static void main(String[] args) {

        CountingBits obj = new CountingBits();
        System.out.println(Arrays.toString(obj.countBits(5)));
    }

    public int countSetBits(int n) {
        int count = 0;
        while(n > 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public int[] countBits(int num) {

        int[] arr = new int[num+1];
        for(int i=0 ; i<=num ; i++) {
            arr[i] = countSetBits(i);
        }
        return arr;
    }
}
