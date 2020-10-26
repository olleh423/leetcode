package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ValidMountainArray {

    public static void main(String[] args) {

        ValidMountainArray obj = new ValidMountainArray();
    }

    public boolean validMountainArray(int[] A) {

        if(A == null || A.length < 3)
            return false;

        int i=0;
        int j=A.length - 1;
        while(i < A.length - 2) {
            if(A[i] < A[i+1])
                i++;
            else
                break;
        }

        while(j > 0) {
            if(A[j] < A[j-1])
                j--;
            else
                break;
        }

        return i == j && i != 0 && j != A.length - 1;
    }
}
