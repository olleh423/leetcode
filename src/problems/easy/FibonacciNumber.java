package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FibonacciNumber {

    public static void main(String[] args) {

        FibonacciNumber obj = new FibonacciNumber();
    }

    public int fib(int N) {

        if(N == 0 || N == 1)
            return N;

        int a = 0;
        int b = 1;

        while(N > 1) {
            int c = a + b;
            a = b;
            b = c;
            N--;
        }

        return b;
    }
}
