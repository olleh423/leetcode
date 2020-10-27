package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
    }

    public int titleToNumber(String s) {

        if(s == null)
            return -1;

        return convert(s, 0);
    }

    private int convert(String str, int i) {

        if(i == str.length() - 1)
            return (int) str.charAt(i) - 64;

        int n = str.charAt(i) - 64;
        return (int) (Math.pow(26, str.length() - (i+1)) * n) + convert(str, i+1);
    }
}
