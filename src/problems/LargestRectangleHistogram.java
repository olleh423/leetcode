package problems;

import java.util.Stack;

public class LargestRectangleHistogram {

	public static int solve(int[] bars) {
		
		Stack<Integer> stack = new Stack<>();
		int i=0, max = 0;
		
		while(i < bars.length) {
			
			if(stack.isEmpty() || bars[stack.peek()] <= bars[i]) {
				
				stack.push(i);
				i++;
				
			} else {
				
				int top = stack.pop();
				int maxLocal = bars[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				max = max < maxLocal ? maxLocal : max;
			}
		}
		
		while(!stack.isEmpty()) {
			
			int top = stack.pop();
			int maxLocal = bars[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			max = max < maxLocal ? maxLocal : max;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		int[] bars = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(solve(bars));
	}
}
