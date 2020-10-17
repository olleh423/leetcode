package problems.hard;

public class FindMinimumInRotatedSortedArray2 {

    public static void main(String[] args) {

        int[] arr = {2,2,2,0,1};
        FindMinimumInRotatedSortedArray2 obj = new FindMinimumInRotatedSortedArray2();

        System.out.println(obj.findMin(arr));
    }

    public int findMin(int[] arr) {

        if(arr == null) return -1;
        return binarySearch(arr, 0, arr.length-1);
    }

    private int binarySearch(int[] A, int low, int high) {

        if(low == high) return A[low];
        if(low + 1 == high) return Math.min(A[low], A[high]);

        int mid = low + (high - low) / 2;

        if(A[low] < A[high])
            return A[low];

        if(A[low] == A[high])
            return binarySearch(A, low, high-1);

        return A[mid] >= A[low] ? binarySearch(A, mid, high) : binarySearch(A, low, mid);
    }
}
