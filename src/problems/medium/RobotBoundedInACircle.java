package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 04-02-2021
 */
public class RobotBoundedInACircle {

    public static void main(String[] args) {

        RobotBoundedInACircle obj = new RobotBoundedInACircle();

        String instructions = "GGLLGG";
        System.out.println(obj.isRobotBounded(instructions));
    }

    public boolean isRobotBounded(String instructions) {

        if(instructions == null)
            return false;

        int[] position = {0, 0};
        int face = 0; //north

        int maxAttampts = 4;
        while(maxAttampts-- > 0) {

            for(int i=0 ; i<instructions.length() ; i++) {

                char ch = instructions.charAt(i);
                if(ch == 'G') {
                    switch(face) {
                        case 0 : {
                            position[1] += 1; break;
                        }
                        case 1 : {
                            position[0] -= 1; break;
                        }
                        case 2 : {
                            position[1] -= 1; break;
                        }
                        case 3 : {
                            position[0] += 1; break;
                        }
                    }
                } else if(ch == 'L') {
                    face = (face + 1) % 4;
                } else {
                    face = face == 0 ? 3 : face - 1;
                }
            }

            if(position[0] == 0 && position[1] == 0 && face == 0)
                return true;
        }

        return false;
    }
}
