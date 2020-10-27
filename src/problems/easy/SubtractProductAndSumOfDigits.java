package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SubtractProductAndSumOfDigits {

    public static void main(String[] args) {

        SubtractProductAndSumOfDigits obj = new SubtractProductAndSumOfDigits();
    }

    public int subtractProductAndSum(int n) {

        int sum = 0;
        int product = 1;
        while(n > 0) {

            int digit = n % 10;
            sum += digit;
            product *= digit;
            n = n / 10;
        }

        return product - sum;
    }
}
