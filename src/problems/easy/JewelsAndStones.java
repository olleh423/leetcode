package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class JewelsAndStones {

    public static void main(String[] args) {

        JewelsAndStones obj = new JewelsAndStones();
    }

    public int numJewelsInStones(String J, String S) {

        if(J == null || S == null)
            return 0;

        Set<Integer> set = new HashSet<Integer>();
        for(int i=0 ; i<J.length() ; i++)
            set.add((int)J.charAt(i));

        int result = 0;
        for(int i=0 ; i<S.length() ; i++) {
            if(set.contains((int)S.charAt(i)))
                result++;
        }

        return result;
    }
}
