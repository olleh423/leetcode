package problems.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        obj.longestConsecutive(arr);
    }

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int a : nums)
            set.add(a);

        int max = 0;
        for(int i=0 ; i<nums.length ; i++) {
            if(! set.contains(nums[i] - 1)) {
                int j = nums[i];
                while(set.contains(j)) {
                    j++;
                }
                max = max < j-nums[i] ? j-nums[i] : max;
            }
        }

        return max;
    }
}
