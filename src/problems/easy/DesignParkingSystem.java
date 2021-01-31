package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 31-01-2021
 */
public class DesignParkingSystem {

    public static void main(String[] args) {

        DesignParkingSystem obj = new DesignParkingSystem();
    }

    private static class ParkingSystem {

        private int[] arr;
        public ParkingSystem(int big, int medium, int small) {

            arr = new int[3];
            arr[0] = big;
            arr[1] = medium;
            arr[2] = small;
        }

        public boolean addCar(int carType) {
            return arr[carType - 1]-- > 0;
        }
    }
}
