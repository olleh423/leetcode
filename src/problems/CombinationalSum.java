package problems;
import java.util.ArrayList;
import java.util.Collections;

public class CombinationalSum {
	
	public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> arr, int n) {
        
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Collections.sort(arr);
		solve(arr, 0, n, new ArrayList<Integer>(), results);
		return results;
    }

    public void solve(ArrayList<Integer> arr, int j, int n, ArrayList<Integer> results, ArrayList<ArrayList<Integer>> mainList) {
        
        if(n == 0) {
            mainList.add(results);
            return;
        }
        
        for(int i=j ; i<arr.size() ; i++) {
            
            if(arr.get(i) <= n) {
                
                ArrayList<Integer> temp = new ArrayList<>(results);
            	results.add(arr.get(i));
                solve(arr, i, n-arr.get(i), results, mainList);
                results = new ArrayList<>(temp);
            }
        }
    }
    
    private void showList(ArrayList<ArrayList<Integer>> list) {
    	
    	for(ArrayList<Integer> a : list) {
    		for(int b : a) {
    			System.out.print(b + " ");
    		}
    		System.out.println();
    	}
    }
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(10);
		list.add(6);
		list.add(11);
		list.add(1);
		list.add(16);
		list.add(8);
		
		int n = 28;
		
		CombinationalSum cs = new CombinationalSum();
		cs.showList(cs.solve(list, n));
	}
}
