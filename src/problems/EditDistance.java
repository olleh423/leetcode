package problems;

public class EditDistance {
	
	public static int min(int a, int b, int c) {
        
        return a < b ? a < c ? a : c : b < c ? b : c;
    }
    
    public static int minDistance(String word1, String word2) {
    
        int[][] res = new int[word2.length() + 1][word1.length() + 1];
        
        for(int i=0 ; i<res.length ; i++) {
            
            for(int j=0 ; j<res[i].length ; j++) {
                
                if(i == 0) {
                    res[i][j] = j;
                } else if (j == 0) {
                    res[i][j] = i;
                } else {
                    if(word2.charAt(i-1) == word1.charAt(j-1)) {
                    	res[i][j] = res[i-1][j-1];
                    } else {
                    	res[i][j] = 1 + min(res[i][j-1], res[i-1][j], res[i-1][j-1]);
                    }
                }
            }
        }
        
        for(int a[] : res) {
        	for(int b : a)
        		System.out.print(b + " ");
        	System.out.println();
        }
        
        return res[word2.length()][word1.length()];
    }
    
    public static void main(String[] args) {
    	    	
    	System.out.println(minDistance("saturday", "sunday"));
    }
}
