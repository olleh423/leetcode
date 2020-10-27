package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DistributeCandiesToPeople {

    public static void main(String[] args) {

        DistributeCandiesToPeople obj = new DistributeCandiesToPeople();
    }

    public int[] distributeCandies(int candies, int num_people) {

        int[] res = new int[num_people];
        int i=0, k=1;
        while(k < candies) {
            res[i % num_people] += k;
            candies -= k++;
            i++;
        }
        res[i % num_people] += candies;
        return res;
    }
}
