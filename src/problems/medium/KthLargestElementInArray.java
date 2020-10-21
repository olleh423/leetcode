package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class KthLargestElementInArray {

    public static void main(String[] args) {

        KthLargestElementInArray obj = new KthLargestElementInArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(obj.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0)
            return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

        for(int n : nums) {

            if(minHeap.size() < k) {
                minHeap.add(n);
            } else if(minHeap.peek() < n) {
                minHeap.poll();
                minHeap.add(n);
            }
        }

        return minHeap.poll();
    }
}
