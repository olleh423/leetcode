package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-10-2020
 */
public class SumOfTwoIntegers {

    public static void main(String[] args) {

        SumOfTwoIntegers obj = new SumOfTwoIntegers();

        System.out.println(obj.getSum(5, 6));
    }

    public int getSum(int a, int b) {
        while(b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}
