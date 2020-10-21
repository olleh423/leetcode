package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class MinimumCostForTickets {

    public static void main(String[] args) {

        MinimumCostForTickets obj = new MinimumCostForTickets();
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(obj.mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {

        if(days == null || costs == null)
            return 0;

        int[] DP = new int[days.length];
        return solveDP(0, days, costs, DP);
    }

    private int solveDP(int i, int[] D, int[] C, int[] DP) {

        if(i >= D.length)
            return 0;

        if(DP[i] > 0)
            return DP[i];

        int oneDay = C[0] + solveDP(i+1, D, C, DP);

        int j = i;
        while(j < D.length) {
            if(D[j] >= D[i] + 7)
                break;
            j++;
        }
        int sevenDay = C[1] + solveDP(j, D, C, DP);

        while(j < D.length) {
            if(D[j] >= D[i] + 30)
                break;
            j++;
        }
        int month = C[2] + solveDP(j, D, C, DP);

        DP[i] = Math.min(oneDay, Math.min(sevenDay, month));
        return DP[i];
    }
}
