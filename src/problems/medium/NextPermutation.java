package problems.medium;

import java.util.Arrays;

/*
 * Auther : Vijay Sharma
 */
public class NextPermutation {

    public static void main(String[] args) {

        NextPermutation obj = new NextPermutation();

        int[] arr = {1,2,3};
        obj.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {

        if(nums == null)
            return;

        if(!solve(nums))
            reverse(nums, 0, nums.length-1);
    }

    private boolean solve(int[] arr) {

        int i=arr.length-1;
        while(i > 0) {

            if(arr[i] > arr[i-1]) {

                int idx = i-1;
                reverse(arr, i, arr.length-1);
                while(idx++ < arr.length) {
                    if(arr[i-1] < arr[idx]) {
                        swap(arr, i-1, idx);
                        return true;
                    }
                }
            }
            i--;
        }

        return false;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
