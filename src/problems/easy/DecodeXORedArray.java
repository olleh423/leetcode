package problems.easy;/*
 * Author : Vijay Sharma 05-03-2021
 */

import java.util.Arrays;

public class DecodeXORedArray {

    public static void main(String[] args) {

        DecodeXORedArray obj = new DecodeXORedArray();

        int[] encoded = {1, 2, 3};
        int first = 1;
        System.out.println(Arrays.toString(obj.decode(encoded, first)));
    }

    public int[] decode(int[] encoded, int first) {

        if(encoded == null) return null;

        int n = encoded.length;
        int[] decoded = new int[n+1];
        decoded[0] = first;

        for(int i=1 ; i<decoded.length ; i++) {
            decoded[i] = decoded[i-1] ^ encoded[i-1];
        }

        return decoded;
    }
}
