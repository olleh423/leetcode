package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 12-02-2021
 */
public class DailyTemperatures {

    public static void main(String[] args) {

        DailyTemperatures obj = new DailyTemperatures();

        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(obj.dailyTemperatures(T)));
    }

    public int[] dailyTemperatures(int[] T) {

        if(T == null) return null;

        int n = T.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<n ; i++) {

            if(stack.isEmpty() || T[stack.peek()] >= T[i]) {
                stack.push(i);
            }
            else {
                while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    int pop = stack.pop();
                    result[pop] = i - pop;
                }
                stack.push(i);
            }
        }

        return result;
    }
}
