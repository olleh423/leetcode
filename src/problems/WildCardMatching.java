package problems;

public class WildCardMatching {

	public static boolean isWildCardMatch(String str, String pattern) {
        
        boolean[][] T = new boolean[1+str.length()][1+pattern.length()];
        T[0][0] = true;
        
        for(int i=1 ; i<T.length ; i++) {
            
            for(int j=1 ; j<T[i].length ; j++) {
                
               if(pattern.charAt(j-1) == '?' || pattern.charAt(j-1) == str.charAt(i-1)) {
                   T[i][j] = T[i-1][j-1];
               } else if(pattern.charAt(j-1) == '*'){
                   T[i][j] = T[i][j-1] || T[i-1][j];
               } else {
            	   T[i][j] = false;
               }
            }
        }
        
        return T[str.length()][pattern.length()];
    }
	
	public static void main(String[] args) {
		
		String str = "aacdbcd";
		String pattern = "a*b?d";
		
		System.out.println(isWildCardMatch(str, pattern));
	}
}
