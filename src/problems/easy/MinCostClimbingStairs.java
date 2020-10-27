package problems.easy;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {

        MinCostClimbingStairs obj = new MinCostClimbingStairs();
    }

    public int minCostClimbingStairs(int[] cost) {

        if(cost == null) return 0;
        if(cost.length == 1) return cost[0];

        int first = cost[0];
        int second = cost[1];

        for(int i=2 ; i<cost.length ; i++) {
            int cIdx = cost[i] + Math.min(first, second);
            first = second;
            second = cIdx;
        }

        return first < second ? first : second;
    }
}
