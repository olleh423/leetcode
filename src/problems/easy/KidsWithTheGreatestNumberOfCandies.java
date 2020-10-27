package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {

        KidsWithTheGreatestNumberOfCandies obj = new KidsWithTheGreatestNumberOfCandies();

        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(obj.kidsWithCandies(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = candies[0];
        for(int i=1 ; i<candies.length ; i++)
            max = Math.max(max, candies[i]);

        List<Boolean> result = new ArrayList<>();

        for(int i=0 ; i<candies.length ; i++)
            result.add(candies[i] + extraCandies >= max);

        return result;
    }
}
