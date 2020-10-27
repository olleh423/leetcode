package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class HammingDistance {

    public static void main(String[] args) {

        HammingDistance obj = new HammingDistance();

        int x = 1, y = 4;
        System.out.println(obj.hammingDistance(x, y));
    }

    public int hammingDistance(int x, int y) {

        int count = 0;
        int xor = x ^ y;
        while(xor > 0) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }
}
