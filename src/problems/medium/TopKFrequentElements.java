package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class TopKFrequentElements {

    public static void main(String[] args) {

        TopKFrequentElements obj = new TopKFrequentElements();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(obj.topKFrequent(nums, k));
    }

    private static class Pair {
        int value, freq;
        Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++)
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((p1, p2) -> p1.freq - p2.freq);
        for(int value : freqMap.keySet()) {
            int freq = freqMap.get(value);
            if(minHeap.size() < k) {
                minHeap.add(new Pair(value, freq));
            }
            else if(minHeap.peek().freq < freq) {
                minHeap.poll();
                minHeap.add(new Pair(value, freq));
            }
        }

        int[] result = new int[k];
        for(int i=0 ; !minHeap.isEmpty() ; i++)
            result[i] = minHeap.poll().value;

        return result;
    }
}
