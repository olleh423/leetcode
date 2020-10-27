package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FindNumberWithEvenNumberOfDigits {

    public static void main(String[] args) {

        FindNumberWithEvenNumberOfDigits obj = new FindNumberWithEvenNumberOfDigits();
    }

    public int findNumbers(int[] nums) {

        int total = 0;

        for(int number : nums) {
            if(String.valueOf(number).length() % 2 == 0)
                total++;
        }

        return total;
    }
}
