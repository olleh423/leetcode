package problems.hard;

import javax.print.attribute.standard.Media;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2}, nums2 = {3, 4};

        MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] A, int[] B) {

        if(A == null || B == null)
            return -1;

        if(A.length > B.length)
            return findMedianSortedArrays(B, A);

        int start = 0;
        int end = A.length;

        int n = A.length;
        int m = B.length;

        while(start <= end) {

            int cut1 = (start + end) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int x1 = cut1 == 0 ? Integer.MIN_VALUE : A[cut1 - 1];
            int x2 = cut1 == n ? Integer.MAX_VALUE : A[cut1];
            int y1 = cut2 == 0 ? Integer.MIN_VALUE : B[cut2 - 1];
            int y2 = cut2 == m ? Integer.MAX_VALUE : B[cut2];

            if(x1 <= y2 && x2 >= y1) {

                if((n + m) % 2 == 0)
                    return (double) (Math.max(x1, y1) + Math.min(x2, y2)) / 2;
                else
                    return Math.max(x1, y1);
            }

            if(x1 > y2)
                end = cut1 - 1;
            else
                start = cut1 + 1;
        }

        return -1;
    }
}
