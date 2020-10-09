package problems;

public class SquareOfSortedArray {

	private static int firstPositiveIndex(int[] arr) {
        
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i] >= 0) return i;
        }
        return arr.length;
    }
    
    public static int[] sortedSquares(int[] arr) {
        
        if(arr == null)
            return null;
        
        int[] result = new int[arr.length];
        
        int i = firstPositiveIndex(arr);
        int j = i-1;
        int k = 0;
        while(j >= 0 || i < arr.length) {
            
            if(j >= 0 && i < arr.length) {
                if(arr[j] * arr[j] > arr[i] * arr[i]) {
                    result[k++] = arr[i] * arr[i];
                    i++;
                } else {
                    result[k++] = arr[j] * arr[j];
                    j--;
                }
            }
            else if(j < 0) {
                result[k++] = arr[i] * arr[i];
                i++;
            }
            else if(i == arr.length) {
                result[k++] = arr[j] * arr[j];
                j--;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	
    	int[] arr = {-4,-1,0,3,10};
    	
    	int[] result = sortedSquares(arr);
    	for(int n : result) {
    		System.out.println(n);
    	}
    }
}
