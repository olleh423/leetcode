package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ImplementRand10UsingRand7 {

    public static void main(String[] args) {

        ImplementRand10UsingRand7 obj = new ImplementRand10UsingRand7();
    }

    public int rand7() {
        // this method is defined in API on leetcode
        return -1;
    }

    public int rand10() {

        while(true) {
            int row = 7 * (rand7() - 1);
            int col = rand7();
            int value = row + col;
            if(value <= 40) {
                return 1 + (value - 1) % 10;
            }
        }
    }
}
