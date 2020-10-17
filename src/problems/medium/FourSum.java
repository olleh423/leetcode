package problems.medium;

import java.util.*;

/*
 * Auther : Vijay Sharma
 */
public class FourSum {

    public static void main(String[] args) {

        FourSum obj = new FourSum();

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        System.out.println(obj.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null) return new ArrayList<>();

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length ; i++) {

            for(int j=i+1 ; j<nums.length ; j++) {

                int s = j+1, e = nums.length - 1;
                while(s < e) {

                    int sum = nums[i] + nums[j] + nums[s] + nums[e];
                    if(sum == target) {

                        result.add(Arrays.asList(nums[i], nums[j], nums[s], nums[e]));
                    }

                    if(sum < target) s++;
                    else e--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
