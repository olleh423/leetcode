package problems;

public class BalanceTheArray {
	
	public static int balance(int[] arr) {
		
		int s = 0, e = arr.length-1;
		int ls = arr[s];
		int rs = arr[e];
		
		while(s < e) {
			
			if(ls < rs) {				
				s++;
				ls += arr[s];				
			} else if(ls > rs) {				
				e--;
				rs += arr[e];
			} else {
				s++; e--;
				ls += arr[s];
				rs += arr[e];
			}
			
			if(s == e && ls == rs) {
				return arr[s];
			}
		}
		
		return ls > rs ? ls - rs : rs - ls;
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 5, 3, 2, 1};
		
		System.out.println(balance(arr));
	}
}
