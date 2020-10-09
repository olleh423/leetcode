package problems;

public class DecodeWays {
	
	private static int decode(String s) {

		int n = s.length();
        if(n == 0) return 0;
        
        int[] ways= new int[n + 1];
        
        ways[0] = 1;
        ways[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for(int i=2 ; i<=n ; i++) {
        	
            if(s.charAt(i-1) !='0') 
                ways[i] = ways[i-1];

            int val = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            
            if(val <= 26 && val >= 10)
                ways[i] += ways[i-2];
        }
        
        return ways[n];
	}

	private static int decode(char[] digits, int n) {
		
		int[] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		
		for(int i=2 ; i<=n ; i++) {
			
			count[i] = 0;
			
			if(digits[i-1] > '0')
				count[i] = count[i-1];
			
			if(digits[i-2] == '1' || (digits[i-2] == '2' && digits[i-1] < '7'))
				count[i] += count[i-2];
		}
		
		return count[n];
	}

	private static int decode(String msg, int n, int[] DP) {
		
		if(n == 0 || n == 1)
			return 1;
		
		if(DP[n-1] != -1)
			return DP[n-1];
		
		int count = 0;
		
		if(msg.charAt(n-1) > '0')
			count += decode(msg, n-1, DP);
		
		if(msg.charAt(n-2) < '2' || (msg.charAt(n-2) == '2' && msg.charAt(n-1) < '7'))
			count += decode(msg, n-2, DP);
		
		DP[n-1] = count;
		return DP[n-1];
	}
	
	public static int waysToDecode(String msg) {
		
		int[] DP = new int[msg.length()];
		for(int i=0 ; i < DP.length ; i++)
			DP[i] = -1;
		
		//return decode(msg, msg.length(), DP);
		
		return decode(msg.toCharArray(), msg.length());
	}
	
	public static void main(String[] args) {
		
		String s = "1023";
		System.out.println("Number of ways to decode : " + waysToDecode(s));
	}
}
