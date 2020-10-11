package problems;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] arr = {10, 5, 7, 2, 1, 9};
        int k = 15;

        MaxLengthSubArrayWithGivenSum obj = new MaxLengthSubArrayWithGivenSum();
        System.out.println(obj.getMaxLength(arr, k));
    }

    private int getMaxLength(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, total = 0;
        for(int i=0 ; i<arr.length ; i++) {
            total += arr[i];
            if(total == k) {
                max = i + 1;
            }
            if(!map.containsKey(total))
                map.put(total, i);

            if(map.containsKey(total - k))
                max = Math.max(max, i - map.get(total - k));
        }
        return max;
    }
}
