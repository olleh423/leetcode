package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 05-01-2021
 */
public class DistributeCandies {

    public static void main(String[] args) {

        DistributeCandies obj = new DistributeCandies();
        int[] candies = {1, 1, 2, 2, 3, 3};
        System.out.println(obj.distributeCandies(candies));
    }

    public int distributeCandies(int[] candyType) {

        Set<Integer> unique = new HashSet<>();
        for(int i=0 ; i<candyType.length ; i++) {
            unique.add(candyType[i]);
        }

        int n = candyType.length;
        return unique.size() > n/2 ? n/2 : unique.size();
    }
}
