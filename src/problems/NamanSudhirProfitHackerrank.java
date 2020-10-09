package problems;

public class NamanSudhirProfitHackerrank {

	public static void profit() {
		
		int[] arr = {0, 5, 4, 3, 4, 5};
		int n = 5;
		
		// n+1 because of 1 based indexing
        int[] naman = new int[n+1]; naman[0] = 0;
        int[] sudhir = new int[n+1]; sudhir[0] = 0;
        
        naman[1] = 0;
        for(int i=2 ; i<=n ; i++) {
            if(arr[i] < arr[i-1]) {
                naman[i] = i-1;
            } else {
                int j = naman[i-1];
                while(j > 0) {
                    if(arr[j] > arr[i])
                        break;
                    j = naman[j];
                }
                naman[i] = j;
            }
        }
        
        sudhir[n] = 0;
        for(int i=n-1 ; i>=1 ; i--) {
        	
        	if(arr[i] < arr[i+1]) {
                sudhir[i] = i+1;
            } else {
                int j = sudhir[i+1];
                while(j > 0) {
                    if(arr[j] > arr[i])
                        break;
                    j = sudhir[j];
                }
                sudhir[i] = j;
            }
        }
        
        int MAX = Integer.MIN_VALUE;
        for(int i=1;  i<=n ; i++) {
        	MAX = Math.max(MAX, naman[i] * sudhir[i]);
        }
        
        System.out.println(MAX);
	}
	
	public static void main(String[] args) {
		
		profit();
	}
}
