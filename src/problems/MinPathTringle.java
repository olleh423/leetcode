package problems;

import java.util.ArrayList;
import java.util.List;

public class MinPathTringle {

	public static int minimumTotal(List<List<Integer>> a) {
        
        int[] arr = new int[a.size()];
        
        for(int i=0 ; i<a.get(a.size()-1).size() ; i++) {
            
            arr[i] = a.get(a.size()-1).get(i);
        }
        for(int i=a.size()-2 ; i>=0 ; i--) {
            
            for(int j=0 ; j<a.get(i).size() ; j++) {
                
                arr[j] = a.get(i).get(j) + Math.min(arr[j], arr[j+1]);
            }
        }
        return arr[0];
    }
	
	public static void main(String[] args) {
		
		List<List<Integer>> list = new ArrayList<>();
		
		list.add(new ArrayList<Integer>(){{add(2);}});
		list.add(new ArrayList<Integer>(){{add(3); add(4);}});
		list.add(new ArrayList<Integer>(){{add(6); add(5); add(7);}});
		list.add(new ArrayList<Integer>(){{add(4); add(1); add(8); add(3);}});
		
		System.out.println(minimumTotal(list));
	}
}
