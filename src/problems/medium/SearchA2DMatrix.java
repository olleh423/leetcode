package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {

        SearchA2DMatrix obj = new SearchA2DMatrix();
    }

    /*
        This matrix has the following properties:
            - Integers in each row are sorted from left to right.
            - The first integer of each row is greater than the last integer of the previous row.
     */
    public boolean searchMatrix(int[][] arr, int target) {

        if(arr == null || arr.length == 0 || arr[0].length == 0) return false;

        int n = arr.length;
        int m = arr[0].length;

        if(arr[0][0] > target || arr[n-1][m-1] < target) return false;

        int i = 0, j = n-1, rowIndex = 0;
        while(i <= j) {

            int mid = (i + j) / 2;
            if(arr[mid][0] == target) return true;

            if(arr[mid][0] < target) {
                rowIndex = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        i = 0; j = m-1;
        while(i <= j) {

            int mid = (i + j) / 2;
            if(arr[rowIndex][mid] == target) return true;

            if(arr[rowIndex][mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return false;
    }
}
