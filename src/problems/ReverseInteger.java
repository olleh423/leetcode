package problems;

/*
 * https://www.interviewbit.com/problems/reverse-integer/
 */

public class ReverseInteger {

	public static int reverse(int n) {
		
		boolean isNegetive = n < 0;
		n = (int) Math.abs(n);
		int res = 0;
		int prev = 0;
		while(n > 0) {
			int d = n % 10;
			res = (res * 10 + d);
			if((res - d) / 10 != prev)
				return 0;
			
			prev = res;
			n /= 10;
		}
		if(isNegetive)
			res *= -1;
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int n = -1146467285;
		System.out.println(reverse(n));
		
		int b = (int)5827646411L;
		System.out.println(b);
	}
}
