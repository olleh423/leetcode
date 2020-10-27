package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RankTransformationOfAnArray {

    public static void main(String[] args) {

        RankTransformationOfAnArray obj = new RankTransformationOfAnArray();
    }

    private static class Holder {
        int value, index, rank;
        Holder(int value, int index) {
            this.value = value;
            this.index = index;
            this.rank = 1;
        }
    }

    public int[] arrayRankTransform(int[] arr) {

        if(arr == null) return null;

        int n = arr.length;
        Holder[] list = new Holder[n];
        for(int i=0 ; i<n ; i++)
            list[i] = new Holder(arr[i], i);

        Arrays.sort(list, (a, b) -> a.value - b.value);

        for(int i=1 ; i<n ; i++)
            list[i].rank = list[i].value == list[i-1].value ? list[i-1].rank : list[i-1].rank + 1;

        int[] result = new int[n];
        for(int i=0 ; i<n ; i++) {
            Holder h = list[i];
            result[h.index] = h.rank;
        }

        return result;
    }
}
