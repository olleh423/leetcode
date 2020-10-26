package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */
public class GreatestCommonDiviserOfStrings {

    public static void main(String[] args) {

        GreatestCommonDiviserOfStrings obj = new GreatestCommonDiviserOfStrings();
        String str1 = "121121121";
        String str2 = "121121";
        System.out.println(obj.gcd(str1, str2));
    }

    public String gcd(String str1, String str2) {

        if(str2.equals(""))return str1;
        while(str1.length() >= str2.length()){
            if(!(str1.substring(0,str2.length())).equals(str2))return "";
            str1 = str1.substring(str2.length(), str1.length());
        }
        return gcd(str2, str1);
    }
}
