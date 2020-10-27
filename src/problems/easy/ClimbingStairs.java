package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ClimbingStairs {

    public static void main(String[] args) {

        ClimbingStairs obj = new ClimbingStairs();

        int n = 9;
        System.out.println(obj.climbStairs(n));
    }

    public int climbStairs(int n) {

        if(n == 0 || n == 1 || n == 2)
            return n;

        int A = 1, B = 2;
        int result = 0;
        for(int i=3 ; i<=n ; i++) {
            result = A + B;
            A = B;
            B = result;
        }
        return result;
    }
}
