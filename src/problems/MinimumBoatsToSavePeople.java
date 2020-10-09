package problems;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/boats-to-save-people/submissions/
 */

public class MinimumBoatsToSavePeople {
	
	private static int minBoats(int[] people, int limit) {
		
	int totalBoatsRequired = 0;
	        
        people = new int[]{3, 2, 3, 2, 2};
        limit = 6;
        
        Arrays.sort(people);
        boolean[] mig = new boolean[people.length];
        System.out.println(Arrays.toString(people));
        for(int i=people.length-1 ; i>=0 ; i--) {            
            if(!mig[i]) {
                int w = people[i];
                int room = limit - w;
                for(int j=i-1 ; j>=0 ; j--) {                
                    if(room >= people[j] && !mig[j]) {                    
                        mig[j] = true;
                        break;
                    }
                }
                mig[i] = true;
                totalBoatsRequired++;
            }
        }
        
        return totalBoatsRequired;
	}

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 3, 2, 2};
		int limit = 6;
		
		System.out.println(minBoats(arr, limit));
	}
}
