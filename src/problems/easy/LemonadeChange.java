package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 23-11-2020
 */
public class LemonadeChange {

    public static void main(String[] args) {

        LemonadeChange obj = new LemonadeChange();
        int[] bills = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        System.out.println(obj.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {

        if(bills.length == 0) return true;

        int five = 0, ten = 0;
        for(int bill : bills) {

            if(bill == 5) {
                five++;
            }
            else if(bill == 10) {
                ten++;
                if(five == 0) return false;
                five--;
            }
            else {
                int left = 15;
                if(ten > 0) {
                    ten--; left = 5;
                }
                if(five < (left / 5)) return false;
                five -= (left / 5);
            }
        }

        return true;
    }
}
