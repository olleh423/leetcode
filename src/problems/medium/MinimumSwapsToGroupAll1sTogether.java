package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 17-01-2021
 */
public class MinimumSwapsToGroupAll1sTogether {

    public static void main(String[] args) {

        MinimumSwapsToGroupAll1sTogether obj = new MinimumSwapsToGroupAll1sTogether();

        int[] data = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        System.out.println(obj.minSwaps(data));
    }

    public int minSwaps(int[] data) {

        if(data == null)
            return 0;

        int n = data.length;
        int numberOfOnes = 0;

        for(int i=0 ; i<n ; i++) {
            numberOfOnes += data[i];
        }

        int numOfZeros = 0;
        for(int i=0 ; i<numberOfOnes ; i++) {
            numOfZeros += (data[i] == 0 ? 1 : 0);
        }

        int minSwaps = numOfZeros;
        int i=1, j=i+numberOfOnes-1;

        while(j < n) {

            if(data[i-1] == 0)
                numOfZeros--;
            if(data[j] == 0)
                numOfZeros++;

            minSwaps = Math.min(minSwaps, numOfZeros);
            i++;
            j++;
        }

        return minSwaps;
    }
}
