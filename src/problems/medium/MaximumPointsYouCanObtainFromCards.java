package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 17-01-2021
 */
public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {

        MaximumPointsYouCanObtainFromCards obj = new MaximumPointsYouCanObtainFromCards();

        int[] cardPoints = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;
        System.out.println(obj.maxScore(cardPoints, k));
    }

    public int maxScore(int[] cardPoints, int k) {

        return solve(cardPoints, k);
    }

    // Sliding window O(n) time, O(1) space
    private int solve(int[] cardPoints, int k) {
        if(cardPoints == null || k == 0)
            return 0;

        int n = cardPoints.length;

        if(k >= n) {
            int total = 0;
            for(int i=0 ; i<n ; i++) {
                total += cardPoints[i];
            }
            return total;
        }

        int sum = 0;
        for(int i=0 ; i<k ; i++) {
            sum += cardPoints[i];
        }

        int max = sum;
        for(int i=k-1 ; i>=0 ; i--) {

            sum -= cardPoints[i];
            sum += cardPoints[n-k+i];
            max = Math.max(sum, max);
        }

        return max;
    }

    // Dynamic programming solution O(n^2) time and space
    private int solve(int i, int j, int[] points, int k, int[][] DP) {

        if(k == 0 || i > j)
            return 0;

        if(DP[i][j] != -1)
            return DP[i][j];

        DP[i][j] = Math.max(points[i] + solve(i+1, j, points, k-1, DP),
                points[j] + solve(i, j-1, points, k-1, DP));

        return DP[i][j];
    }
}
