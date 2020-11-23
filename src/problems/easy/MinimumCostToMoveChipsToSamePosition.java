package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 23-11-2020
 */
public class MinimumCostToMoveChipsToSamePosition {

    public static void main(String[] args) {

        MinimumCostToMoveChipsToSamePosition obj = new MinimumCostToMoveChipsToSamePosition();

        int[] position = {2, 2, 2, 3, 3};
        System.out.println(obj.minCostToMoveChips(position));
    }

    public int minCostToMoveChips(int[] position) {

        if(position == null || position.length == 0)
            return 0;

        int even = 0, odd = 0;
        for(int n : position) {
            if(n % 2 == 0) even++;
            else odd++;
        }

        if(even == position.length || odd == position.length)
            return 0;

        return Math.min(even, odd);
    }
}
