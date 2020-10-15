package problems;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {

    public static void main(String[] args) {

        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;

        MissingRanges_163 obj = new MissingRanges_163();
        System.out.println(obj.findMissingRanges(nums, lower, upper));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();

        int n = nums.length;
        if(nums == null || n == 0) {
            result.add(lower == upper ? String.valueOf(lower) : lower + "->" + upper);
            return result;
        }

        if(nums[0] - lower > 0)
            result.add((lower == nums[0] - 1) ? String.valueOf(lower): lower + "->" + (nums[0] - 1));

        for(int i=1 ; i<n ; i++) {
            if(nums[i] - nums[i-1] > 1) {

                if(nums[i-1]+1 == nums[i]-1)
                    result.add(String.valueOf(nums[i]-1));
                else
                    result.add((nums[i-1]+1) + "->" + (nums[i]-1));
            }
        }

        if(upper - nums[n-1] > 0)
            result.add((nums[n-1]+1) == upper ? String.valueOf(upper) : (nums[n-1] + 1) +"->"+upper);

        return result;
    }
}
