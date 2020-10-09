package problems;

import java.util.Stack;

public class MaximalRectangle_Leetcode_85 {

    public static void main(String[] args) {

        MaximalRectangle_Leetcode_85 obj = new MaximalRectangle_Leetcode_85();

        char[][] matrix = { {'1', '0', '1', '0', '0'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'}};

        int maxArea = obj.maximalRectangle(matrix);
        System.out.println("Max area : " + maxArea);
    }

    public int maximalRectangle(char[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int cols = matrix[0].length;
        int[] bars = new int[cols];

        int maxArea = 0;
        for(int i=0 ; i<matrix.length ; i++) {
            char[] row = matrix[i];
            for(int j=0 ; j<row.length ; j++) {
                bars[j] = row[j] == '1' ? bars[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, getMaxArea(bars));
        }

        return maxArea;
    }

    private int getMaxArea(int[] bars) {

        int i = 0, n = bars.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        while(i < n) {
            if(stack.isEmpty() || bars[stack.peek()] <= bars[i]) {
                stack.push(i++);
            }
            else {
                int top = stack.pop();
                int localMax = bars[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(localMax, maxArea);
            }
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();
            int localMax = bars[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(localMax, maxArea);
        }

        return maxArea;
    }
}
