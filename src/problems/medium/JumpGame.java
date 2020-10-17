package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class JumpGame {

    public static void main(String[] args) {

        JumpGame obj = new JumpGame();
        int[] arr = {2,3,1,1,4};
        System.out.println(obj.canJump(arr));
    }

    public boolean canJump(int[] arr) {

        if(arr == null) return false;
        if(arr.length == 1) return true;

        int target = arr.length - 1;
        int i = target - 1;

        while(i >= 0) {
            if(arr[i] >= target - i) {
                if(i == 0) return true;
                target = i;
            }
            i--;
        }

        return false;
    }
}
