package problems.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};

        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        System.out.println(obj.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int i=0, max=0;

        while(i < heights.length) {

            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int top = stack.pop();
                int maxLocal = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(max, maxLocal);
            }
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();
            int maxLocal = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            max = Math.max(max, maxLocal);
        }

        return max;
    }
}
