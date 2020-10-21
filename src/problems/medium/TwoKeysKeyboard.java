package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-10-2020
 */
public class TwoKeysKeyboard {

    public static void main(String[] args) {

        TwoKeysKeyboard obj = new TwoKeysKeyboard();

        int n = 43;
        System.out.println(obj.minSteps(n));
    }

    private boolean isPrime(int n) {

        for(int i=2 ; i<=Math.ceil(Math.sqrt(n)) ; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    private int getLargestDiviser(int n) {
        for(int i=n/2 ; i>=2 ; i--) {
            if(n % i == 0) return i;
        }
        return 0;
    }

    public int minSteps(int n) {

        if(n == 1) return 0;

        if(n % 2 == 0) {
            return 2 + minSteps(n/2);
        } else {
            if(isPrime(n)) {
                return n;
            } else {
                int k = getLargestDiviser(n);
                return (n / k) + minSteps(k);
            }
        }
    }
}
