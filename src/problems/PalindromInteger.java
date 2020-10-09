package problems;

/*
 * https://www.interviewbit.com/problems/palindrome-integer/
 */

public class PalindromInteger {

	public static boolean isPalin(int n) {
		
		int temp = n;
        int digits = 0;
        while(temp > 0) {
            digits++;
            temp /= 10;
        }
        
        if(digits == 1) 
            return true;
        
        int div = (int) Math.pow(10, digits-1);
        for(int i=0 ; i<digits/2 ; i++) {
            
            int head = (n / div) % 10;
            int tail = n % 10;
            if(head != tail)
                return false;
            div /= 100;
            n /= 10;
        }
        return true;
	}
	
	public static void main(String[] args) {
		
		int n = 1215665121;
		System.out.println(isPalin(n));
	}
}
