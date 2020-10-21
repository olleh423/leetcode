package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class SingleNumber3 {

    public static void main(String[] args) {

        SingleNumber3 obj = new SingleNumber3();
        int [] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(obj.singleNumber(arr)));
    }

    public int[] singleNumber(int[] arr) {

        if(arr == null || arr.length == 0)
            return null;

        int xor = 0;
        for(int i=0 ; i<arr.length ; i++) {
            xor = xor ^ arr[i];
        }

        int setBit = xor & ~(xor - 1);
        int x = 0, y = 0;

        for(int i=0 ; i<arr.length ; i++) {
            if((arr[i] & setBit) == 0)
                x = x ^ arr[i];
            else
                y = y ^ arr[i];
        }

        return new int[]{x, y};
    }
}
