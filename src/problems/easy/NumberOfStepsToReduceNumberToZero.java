package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class NumberOfStepsToReduceNumberToZero {

    public static void main(String[] args) {

        NumberOfStepsToReduceNumberToZero obj = new NumberOfStepsToReduceNumberToZero();
    }

    public int numberOfSteps (int num) {

        int count = 0;
        while(num > 0) {
            if(num % 2 == 0)
                num /= 2;
            else
                num--;

            count++;
        }
        return count;
    }
}
