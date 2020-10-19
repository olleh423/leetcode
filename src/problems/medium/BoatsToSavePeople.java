package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class BoatsToSavePeople {

    public static void main(String[] args) {

        BoatsToSavePeople obj = new BoatsToSavePeople();
        int[] people = {3, 2, 2, 1};
        int limit = 3;
    }

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int left = 0, right = people.length - 1, result = 0;
        while(left <= right) {
            if(people[left] + people[right] <= limit)
                left++;
            right--;
            result++;
        }
        return result;
    }
}
