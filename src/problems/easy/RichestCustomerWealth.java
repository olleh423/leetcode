package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 31-01-2021
 */
public class RichestCustomerWealth {

    public static void main(String[] args) {

        RichestCustomerWealth obj = new RichestCustomerWealth();

        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(obj.maximumWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {

        if(accounts == null)
            return 0;

        int maxWealth = Integer.MIN_VALUE;
        for(int i=0 ; i<accounts.length ; i++) {

            int ithWealth = 0;
            for(int j=0 ; j<accounts[i].length ; j++) {

                ithWealth += accounts[i][j];
            }

            maxWealth = Math.max(maxWealth, ithWealth);
        }

        return maxWealth;
    }
}
