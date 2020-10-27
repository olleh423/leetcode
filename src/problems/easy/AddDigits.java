package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class AddDigits {

    public static void main(String[] args) {

        AddDigits obj = new AddDigits();
    }

    public int addDigits(int num) {

        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        return num % 9;
    }
}
