package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 23-11-2020
 */
public class WaterBottles {

    public static void main(String[] args) {

        WaterBottles obj = new WaterBottles();

        int n = 15, ex = 4;
        System.out.println(obj.numWaterBottles(n, ex));
    }

    public int numWaterBottles(int numBottles, int numExchange) {

        int result = 0;

        int full = numBottles, empty = 0;
        while((full + empty) >= numExchange) {

            result += full;
            int exchange = (full + empty) / numExchange;
            empty = (full + empty) % numExchange;
            full = exchange;
        }

        return result + full;
    }
}
