package problems;

public class NumberOfMaxHeap {

	private long[] dp;  	/* dp[i] = number of max heaps for i distinct integers */
	private long[][] nck;	/* nck[i][j] = i choose j if i>=j else 0 */
	private int[] log2;		/* log2[i] = int(log base 2 of i) */
    
	private static final long MOD = 1000000007;
    
    private long choose(int n,int k) {
    	
        if(k>n) return 0;
        
		if(n<=1) return 1;
		
		if(k==0) return 1;

        if(nck[n][k]!=-1) return nck[n][k];
        
        long answer = choose(n-1,k-1) + choose(n-1,k);
        answer %= MOD;
        nck[n][k] = answer;
        return answer;
    }
    
    private int getL(int n) {
    	
        if(n==1) return 0;
            
        int h = log2[n];
        int p = n - ((1<<(h)) - 1);
        int m = (1<<h);
        
        return p>=(m/2) ? (1<<(h)) - 1 : (1<<(h)) - 1 - ((m/2) - p);
    }
    
    private int solve(int n) {
    	
        dp = new long[n+1];
        for(int i=0 ; i<=n ; i++)
            dp[i]=-1;
            
        nck = new long[n+1][n+1];
        
        for(int i=0 ; i<=n ; i++)
            for(int j=0 ; j<=n ; j++)
                nck[i][j] = -1;
                
        log2 = new int[n+1];
        
        int currLogAnswer = -1;
        int currPower2 = 1;
        
        for(int i=1;i<=n;i++) {
        	
		    if(currPower2==i) {
		    	
	            currLogAnswer++;
	            currPower2*=2;
	        }
	        log2[i] = currLogAnswer;
        }
        
        return (int) getNumberOfMaxHeaps(n);
    }
    
    private long getNumberOfMaxHeaps(int n) {
    	
        if(n <= 1) return 1;
            
        if(dp[n] != -1) return dp[n];

        int L = getL(n);
        long ans = (choose(n-1,L) * getNumberOfMaxHeaps(L)) % MOD *(getNumberOfMaxHeaps(n-1-L));
        ans %= MOD;
        dp[n] = ans;
        return ans;
    }
    
    public static void main(String[] args) {
    	
    	NumberOfMaxHeap obj = new NumberOfMaxHeap();
    	System.out.println(obj.getNumberOfMaxHeaps(5));
    }
}
