package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class HIndex2 {

    public static void main(String[] args) {

        HIndex2 obj = new HIndex2();

        int[] citations = {0, 1, 3, 5, 6};
        System.out.println(obj.hIndex(citations));
    }

    public int hIndex(int[] citations) {

        if(citations == null)
            return 0;

        int n = citations.length;
        int low = 0, high = n - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;
            if(citations[mid] == n - mid)
                return n - mid;

            if(citations[mid] > n - mid)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return n - low;
    }
}
