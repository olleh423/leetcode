package problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Auther : Vijay Sharma 17-10-2020
 */
public class K_DiffPairInArray {

    public static void main(String[] args) {

        K_DiffPairInArray obj = new K_DiffPairInArray();

        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;

        System.out.println(obj.findPairs(nums, k));
    }

    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int l=0,r=1;
        Set<Integer> set = new HashSet<>();
        while(l < nums.length && r < nums.length) {

            if(nums[r] - nums[l] < k || r == l) {
                r++;
            }
            else if(nums[r] - nums[l] > k){
                l++;
            }
            else {
                set.add(nums[l]);
                l++;
                r++;
            }
        }
        return set.size();
    }
}
