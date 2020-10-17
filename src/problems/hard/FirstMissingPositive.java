package problems.hard;

public class FirstMissingPositive {

    public static void main(String[] args) {

        int[] arr = {7,8,9,11,12};

        FirstMissingPositive obj = new FirstMissingPositive();
        System.out.println(obj.firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] arr) {

        if(arr == null) return 0;

        int n = arr.length;
        int i = 0;

        while(i < n) {
            int temp = arr[i];
            if(temp > 0 && temp <= n && temp - 1 != i && arr[i] != arr[temp-1]) {
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            } else {
                i++;
            }
        }

        for(int k=0 ; k<n ; k++) {
            if(arr[k]-1 != k)
                return k + 1;
        }

        return n + 1;
    }
}
