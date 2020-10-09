package problems;

public class PalindromPartition {
	
	public static int palindromPartition(String str) {
		
		if(str == null || str.isEmpty() || str.length() == 1)
			return 0;
		
		if(str.length() == 2)
			return str.charAt(0) == str.charAt(1) ? 0 : 1;
		
		boolean[][] lookup = new boolean[str.length()][str.length()];
		for(int i=0 ; i<str.length() ; i++) {
			lookup[i][i] = true;
		}
		for(int i=0 ; i<str.length()-1 ; i++) {
			lookup[i][i+1] = str.charAt(i) == str.charAt(i+1);
		}
		
		int n = str.length();
		for(int curr=3 ; curr <= n ; curr++) {
			for(int i=0 ; i < n - curr + 1 ; i++) {
				int j = i + curr - 1;
				if(str.charAt(i) == str.charAt(j) && lookup[i+1][j-1]) {
					lookup[i][j] = true;
				}
			}
		}
		
		int[] cuts = new int[str.length()];
		
		for(int i=0 ; i<n ; i++) {
			
			int min = Integer.MAX_VALUE;
			if(lookup[0][i]) {
				cuts[i] = 0;
			} else {
				for(int j=0 ; j<i ; j++) {
					if(lookup[j+1][i] && min > cuts[j] + 1) {
						min = cuts[j] + 1;
					}
				}
				cuts[i] = min;
			}
		}
		
		return cuts[cuts.length - 1];
	}

	public static int getMinimumCuts(String str) {
		
		if(str.length() == 0) 
			return 0;
		
		int[] cut = new int[str.length()];
		boolean[][] res = new boolean[str.length()][str.length()];
		
		for(int i=0 ; i<str.length() ; i++) {
			
			int min = i;
			for(int j=0 ; j<=i ; j++) {
				
				if(str.charAt(i) == str.charAt(j) && (j+1 >= i || res[i-1][j+1])) {
					res[i][j] = true;
					min = Math.min(min, j == 0 ? 0 : 1 + cut[j-1]);
				}
			}
			cut[i] = min;
		}
		
        return cut[str.length() - 1];
    }
	
	public static void main(String[] args) {
		
		String s = "abb";
		
		System.out.println(getMinimumCuts(s));
		System.out.println(palindromPartition(s));
	}
}
