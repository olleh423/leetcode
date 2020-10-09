package problems;

/*
 * 
 * Given numbers n and k, 1 <= k < INT_MAX, return kth permutation of the set [1,2,…,n]. For example, 
 * given n=3 and k=4, the permutations of [1,2,3] in order are:
	“123”
	“132”
	“213”
	“231”
	“312”
	“321”
	k=4th permutation is “231”. To simplify the output, a string concatenation of the numbers is returned.
 * 
 */

public class KthPermutation {

	private String createStringOfLengthN(int n) {
		String str = "";
		for(int i=1 ; i<=n ; i++)
			str += i;
		return str;
	}
	
	private int fact(int n, int fact) {
		if(n == 1) return fact;
		return fact(n-1, fact*n);
	}
	
	private String kthPermutation(String str, int n, int fact, int k) {
		if(n == 1) 
			return str;
		
		int per = fact / n;
		int firstCharIndex = k / per;
		char ch = str.charAt(firstCharIndex);
		String remaining = new StringBuffer(str).deleteCharAt(firstCharIndex).toString();
		
		return ch + kthPermutation(remaining, n-1, per, k - (firstCharIndex * per));
	}
	
	private String kthPermutation(String str, int k) {

		int fact = fact(str.length(), 1);
		if(k > fact) return "";
		return kthPermutation(str, str.length(), fact, k-1);
	}
	
	public String kth_per(int n, int k) {
		
		String str = createStringOfLengthN(n);
		return kthPermutation(str, k);
	}
	
	public static void main(String[] args) {
		
		int n = 2;
		int k = 5;
		
		KthPermutation kp = new KthPermutation();
		System.out.println(kp.kth_per(n, k));
	}
}
