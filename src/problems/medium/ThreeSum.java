package problems.medium;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        ThreeSum obj = new ThreeSum();

        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(obj.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums == null)
            return result;

        Set<String> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0 ; i<nums.length ; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {

                int value = nums[i] + nums[left] + nums[right];
                String key = nums[i]+":"+nums[left]+":"+nums[right];
                if(value == 0 && !set.contains(key)) {
                    set.add(key);
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;
                }
                else if(value > 0)
                    right--;
                else
                    left++;
            }
        }


        return result;
    }
}
