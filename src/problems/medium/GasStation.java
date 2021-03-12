package problems.medium;/*
 * Author : Vijay Sharma 12-03-2021
 */

public class GasStation {

    public static void main(String[] args) {

        GasStation obj = new GasStation();

        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};

        System.out.println(obj.canCompleteCircuit(gas, cost));
        System.out.println(obj.canCompleteCircuit_2(gas, cost));
    }

    /*
     * Efficient : Runtime O(n);
     */
    public int canCompleteCircuit_2(int[] gas, int[] cost) {

        if(gas == null || cost == null) return -1;

        int count = 0, balance = 0, start = 0;
        int n = gas.length;

        while(count < n && start < 2 * n) {

            balance += gas[start % n] - cost[start % n];
            if(balance < 0) {
                count = 0;
                balance = 0;
            } else {
                count++;
            }
            start++;
        }

        return count < n ? -1 : start % n;
    }


    /*
     * Brute force - Runtime : O(n^2)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if(gas == null || cost == null) return -1;

        int n = gas.length;
        for(int i=0 ; i<n ; i++) {
            if(canCompleteFromIndex(i, gas, cost))
                return i;
        }
        return -1;
    }

    private boolean canCompleteFromIndex(int i, int[] gas, int[] cost) {

        int balance = 0;
        int end = i, start = i, n = gas.length;
        do {
            if(balance + gas[start] < cost[start])
                return false;

            balance = balance + gas[start] - cost[start];
            start = (start + 1) % n;
        }
        while(start != end);

        return true;
    }
}
