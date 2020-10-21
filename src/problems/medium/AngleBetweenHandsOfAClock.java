package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class AngleBetweenHandsOfAClock {

    public static void main(String[] args) {

        AngleBetweenHandsOfAClock obj = new AngleBetweenHandsOfAClock();
        int hour = 5;
        int minutes = 33;
        System.out.println(obj.angleClock(hour, minutes));
    }

    public double angleClock(int hour, int minutes) {

        double result = Math.abs((double)((30 * hour) - (5.5 * minutes)));
        return Math.min(360 - result, result);
    }
}
