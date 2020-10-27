package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DefangingAnIPAddress {

    public static void main(String[] args) {

        DefangingAnIPAddress obj = new DefangingAnIPAddress();

        String address = "255.100.50.0";
        System.out.println(obj.defangIPaddr(address));
    }

    public String defangIPaddr(String address) {

        if(address == null)
            return null;

        String result = "";
        for(int i=0 ; i<address.length() ; i++) {

            char ch = address.charAt(i);
            if(ch == '.')
                result += "[.]";
            else
                result += ch;
        }

        return result;
    }
}
