package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class NonDecreasingArray {

    public static void main(String[] args) {

        NonDecreasingArray obj = new NonDecreasingArray();

        int[] arr = {4, 2, 3};
        System.out.println(obj.checkPossibility(arr));
    }

    public boolean checkPossibility(int[] arr) {

        if(arr == null) return false;
        if(arr.length == 1) return true;

        int count = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]) {
                if(i == 1 || arr[i-2] <= arr[i]){
                    arr[i-1] = arr[i];count++;
                }else{
                    arr[i] = arr[i-1];count++;
                }
            }
        }
        return count <= 1;
    }
}
