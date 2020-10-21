package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class IntegerToRoman {

    public static void main(String[] args) {

        IntegerToRoman obj = new IntegerToRoman();
        int n = 543;
        System.out.println(obj.intToRoman(n));
    }

    public String intToRoman(int num) {

        if(num == 0)
            return "";

        StringBuilder result = new StringBuilder();

        if(num / 1000 != 0) {
            int div = num / 1000;
            for(int i=0 ; i<div ; i++)
                result.append("M");
            num %= 1000;
        }
        if(num / 900 != 0) {
            result.append("CM");
            num %= 900;
        }
        if(num / 500 != 0) {
            int div = num / 500;
            for(int i=0 ; i<div ; i++)
                result.append("D");
            num %= 500;
        }
        if(num / 400 != 0) {
            result.append("CD");
            num %= 400;
        }
        if(num / 100 != 0) {
            int div = num / 100;
            for(int i=0 ; i<div ; i++)
                result.append("C");
            num %= 100;
        }
        if(num / 90 != 0) {
            result.append("XC");
            num %= 90;
        }
        if(num / 50 != 0) {
            int div = num / 50;
            for(int i=0 ; i<div ; i++)
                result.append("L");
            num %= 50;
        }
        if(num / 40 != 0) {
            result.append("XL");
            num %= 40;
        }
        if(num / 10 != 0) {
            int div = num / 10;
            for(int i=0 ; i<div ; i++)
                result.append("X");
            num %= 10;
        }
        if(num / 9 != 0) {
            result.append("IX");
            num %= 9;
        }
        if(num / 5 != 0) {
            int div = num / 5;
            for(int i=0 ; i<div ; i++)
                result.append("V");
            num %= 5;
        }
        if(num / 4 != 0) {
            result.append("IV");
            num %= 4;
        }
        if(num / 1 != 0) {
            int div = num / 1;
            for(int i=0 ; i<div ; i++)
                result.append("I");
        }

        return result.toString();
    }
}
