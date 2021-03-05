package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 22-02-2021
 */
public class GrumpyBookstoreOwner {

    public static void main(String[] args) {

        GrumpyBookstoreOwner obj = new GrumpyBookstoreOwner();

        int[] customers = {4, 10, 10};
        int[] grumpy = {1, 1, 0};
        int X = 2;

        System.out.println(obj.maxSatisfied(customers, grumpy, X));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        if(customers == null || grumpy == null)
            return 0;

        int n = customers.length;
        int happyCustomers = 0;

        for(int i=0 ; i<n ; i++) {

            if(i < X)
                happyCustomers += customers[i];
            else
                happyCustomers += (grumpy[i] == 0 ? customers[i] : 0);
        }

        int wl = 1, wr = X, max = happyCustomers;
        while(wr < n) {

            if(grumpy[wl-1] == 1) happyCustomers -= customers[wl-1];
            if(grumpy[wr] == 1) happyCustomers += customers[wr];
            wl++;
            wr++;
            max = Math.max(max, happyCustomers);
        }

        return max;
    }
}
