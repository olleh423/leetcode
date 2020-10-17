package problems;

public class JumpGame_55 {

    public static void main(String[] args) {

        int[] jumps = {3, 2, 1, 0, 4};

        JumpGame_55 obj = new JumpGame_55();
        System.out.println(obj.canJump(jumps));
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
