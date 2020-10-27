package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class BaseballGame {

    public static void main(String[] args) {

        BaseballGame obj = new BaseballGame();

        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(obj.calPoints(ops));
    }

    public int calPoints(String[] ops) {

        Stack<String> stack = new Stack<>();
        int total = 0;

        for(int i=0 ; i<ops.length ; i++) {

            String si = ops[i];

            if("+".equals(si)) {
                int lastRound = Integer.parseInt(stack.pop());
                int secondLastRound = Integer.parseInt(stack.peek());
                stack.push(String.valueOf(lastRound));
                int totalScore = lastRound + secondLastRound;
                total += totalScore;
                stack.push(String.valueOf(totalScore));
            }
            else if("D".equals(si)) {
                int top = Integer.parseInt(stack.peek());
                int score = top * 2;
                total += score;
                stack.push(String.valueOf(score));
            }
            else if("C".equals(si)) {
                total = total -  Integer.parseInt(stack.pop());
            }
            else {
                int score = Integer.parseInt(si);
                total += score;
                stack.push(String.valueOf(score));
            }
        }

        return total;
    }
}
