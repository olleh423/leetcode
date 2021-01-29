package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 29-01-2021
 */
public class PairsOfSongsWitTotalDurationDivisibleBy60 {

    public static void main(String[] args) {

        PairsOfSongsWitTotalDurationDivisibleBy60 obj = new PairsOfSongsWitTotalDurationDivisibleBy60();

        int[] time = {60, 60, 60};
        System.out.println(obj.numPairsDivisibleBy60(time));
    }

    public int solve(int[] time) {

        if(time == null)
            return 0;

        int totalPairs = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0 ; i<time.length ; i++) {
            totalPairs += time[i] % 60 == 0 ? freq.getOrDefault(0, 0) : freq.getOrDefault(60 - time[i] % 60, 0);
            freq.put(time[i] % 60, freq.getOrDefault(time[i] % 60, 0) + 1);
        }

        return totalPairs;
    }

    public int numPairsDivisibleBy60(int[] time) {

        if(time == null)
            return 0;

        int n = time.length;
        for(int i=0 ; i<n ; i++) {
            time[i] %= 60;
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            frequencies.put(time[i], frequencies.getOrDefault(time[i], 0) + 1);
        }

        int totalPairs = 0;
        for(int i=0 ; i<n ; i++) {

            int remainingTime = 60 - time[i];
            if(time[i] == 0) {
                totalPairs += (frequencies.get(time[i]) - 1);
            }
            else if(remainingTime != time[i]) {
                totalPairs += frequencies.getOrDefault(remainingTime, 0);
            }
            else {
                totalPairs += (frequencies.get(remainingTime) - 1);
            }
        }

        return totalPairs / 2;
    }
}
