package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class XorOperationInAnArray {

    public static void main(String[] args) {

        XorOperationInAnArray obj = new XorOperationInAnArray();
    }

    public int xorOperation(int n, int start) {

        int xor = 0;
        for(int i=0 ; i<n ; i++) {
            xor ^= (start + 2 * i);
        }
        return xor;
    }
}
