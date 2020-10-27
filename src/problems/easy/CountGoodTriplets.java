package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class CountGoodTriplets {

    public static void main(String[] args) {

        CountGoodTriplets obj = new CountGoodTriplets();
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        if(arr == null)
            return 0;

        int n = arr.length;
        int count = 0;

        for(int i=0 ; i<=n-3 ; i++) {
            for(int j=i+1 ; j<=n-2 ; j++) {
                for(int k=j+1 ; k<=n-1 ; k++) {

                    if(Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c)
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
