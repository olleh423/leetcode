package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(obj.search(nums, target));
    }

    public int search(int[] nums, int target) {

        if(nums == null) return -1;

        int s = 0, e = nums.length-1;
        while(s <= e) {

            int mid = (s + e) / 2;

            if(nums[mid] == target)
                return mid;

            if(nums[s] <= nums[mid]) {
                if(target >= nums[s] && target < nums[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            }
            else if(target > nums[mid] && target <= nums[e]) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return -1;
    }
}
