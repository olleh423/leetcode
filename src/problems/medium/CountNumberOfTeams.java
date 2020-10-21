package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class CountNumberOfTeams {

    public static void main(String[] args) {

        CountNumberOfTeams obj = new CountNumberOfTeams();
        int[] rating = {2, 5, 3, 4, 1};
        System.out.println(obj.numTeams(rating));
    }

    public int numTeams(int[] rating) {

        if(rating == null)
            return 0;

        int length = rating.length;
        int [] dp = new int[length];
        int count = 0;
        for (int i=0; i<length; i++) {
            for (int j=i; j>=0; j--) {
                if (rating[i] < rating[j]) {
                    dp[i] += 1;
                    count += dp[j];
                }
            }
        }
        dp = new int[length];
        for (int i=0; i<length; i++) {
            for (int j=i; j>=0; j--) {
                if (rating[i] > rating[j]) {
                    dp[i] += 1;
                    count += dp[j];
                }
            }
        }
        return count;
    }
}
