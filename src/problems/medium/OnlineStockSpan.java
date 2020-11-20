package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-11-2020
 */
public class OnlineStockSpan {

    public static void main(String[] args) {

        OnlineStockSpan obj = new OnlineStockSpan();
    }

    private static class Holder {
        int index, value;
        Holder(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private int i;
    private Stack<Holder> stack;

    public OnlineStockSpan() {
        i = 0;
        stack = new Stack<>();
    }

    public int next(int price) {

        if(stack.isEmpty()) {
            stack.push(new Holder(i++, price));
            return 1;
        }

        while(!stack.isEmpty() && stack.peek().value <= price)
            stack.pop();

        int n = stack.isEmpty() ? i + 1 : i - stack.peek().index;
        stack.push(new Holder(i++, price));
        return n;
    }
}
