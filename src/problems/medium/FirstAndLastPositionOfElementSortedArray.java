package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class FirstAndLastPositionOfElementSortedArray {

    public static void main(String[] args) {

        FirstAndLastPositionOfElementSortedArray obj = new FirstAndLastPositionOfElementSortedArray();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println(obj.searchRange(nums, target));
    }

    public int[] searchRange(int[] arr, int target) {

        int[] result = {-1, -1};
        if(arr == null) return result;

        int left = find(arr, target, false);
        if(left == -1) return result;
        int right = find(arr, target, true);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int find(int[] arr, int target, boolean isRight) {

        int low = 0, high = arr.length - 1;
        int index = -1;
        while(low <= high) {

            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                index = mid;
                if(isRight) low = mid + 1;
                else high = mid - 1;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return index;
    }
}
