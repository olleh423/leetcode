package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class NumberOfEquivalentDominoPairs {

    public static void main(String[] args) {

        NumberOfEquivalentDominoPairs obj = new NumberOfEquivalentDominoPairs();

        int[][] dominos = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(obj.numEquivDominoPairs(dominos));
    }

    public int numEquivDominoPairs(int[][] dominoes) {

        if(dominoes == null)
            return 0;

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0 ; i<dominoes.length ; i++) {
            int[] A = dominoes[i];
            int num = Math.min(A[0], A[1]) * 10 + Math.max(A[0], A[1]);
            int pairs = map.getOrDefault(num, 0);
            result += pairs;
            map.put(num, pairs + 1);
        }

        return result;
    }
}
