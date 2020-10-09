package problems;

import java.util.Stack;

public class LongestValidParentheses {

	public static int getLengthOfLVP(String str) {
		
		if(str.isEmpty())
			return 0;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		
		int result = 0;
		for(int i=0 ; i<str.length() ; i++) {
			
			if(str.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				} else {
					result = Math.max(i-stack.peek(), result);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String str = "(())()))()";
		System.out.println("Length of longest valid parenthesis is " + getLengthOfLVP(str));
	}
}
