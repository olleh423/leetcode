package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class RotateArray {

    public static void main(String[] args) {

        RotateArray obj = new RotateArray();
    }

    public void rotate(int[] nums, int k) {

        if(nums == null) return;

        int n = nums.length;
        k = k % n;

        if(k == 0) return;

        k = n - k;

        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);
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
