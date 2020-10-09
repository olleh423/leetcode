package problems;

/*
 * Return true if the given number n is power of 2 else false. 
 * constraints : 1 >= n >= 2^64
 */

public class PowerOfTwo {

	public static void main(String[] args) {
		
		String n = "34359738368";
		System.out.println(n + " is" + (isPowerOfTwo(n) ? "" : " not") + " a power of 2");
	}
	
	public static boolean isPowerOfTwo(String n) {
		
		while(true) {
			
			if("2".equals(n))
				return true;
			
			String res = "";
			int carry = 0;
			
			for(int i=0 ; i<n.length() ; i++) {
				
				int digit = Integer.parseInt(String.valueOf(n.charAt(i)));
				
				if(digit < 2 && carry == 0) {
					res += (i != 0 ? "0" : "");
					carry = digit;
				} else {
					digit = carry != 0 ? carry * 10 + digit : digit;
					carry = digit % 2;
					res += digit / 2;
				}
			}
			
			if(carry > 0)
				return false;
			
			n = res;
		}
	}
}
