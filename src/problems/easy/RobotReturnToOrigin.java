package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RobotReturnToOrigin {

    public static void main(String[] args) {

        RobotReturnToOrigin obj = new RobotReturnToOrigin();

        String steps = "ULRRDL";
        System.out.println(obj.judgeCircle(steps));
    }

    public boolean judgeCircle(String moves) {

        int U=0, D=0, R=0, L=0;

        char[] arr = moves.toCharArray();

        for(int i=0 ; i<arr.length ; i++) {

            switch(arr[i]) {
                case 'U' :
                    U++;
                    break;
                case 'D' :
                    D++;
                    break;
                case 'L' :
                    L++;
                    break;
                case 'R' :
                    R++;
                    break;
            }
        }

        return U == D && L == R;
    }
}
