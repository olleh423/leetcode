package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ToplogicalSortArray {

	public static ArrayList<Integer> topologicalSort(ArrayList<Integer> jobs, ArrayList<Integer[]> deps) {
	    
		ArrayList<Integer> result = new ArrayList<>();
		
		if(jobs == null || deps == null)
			return result;
		
		HashMap<Integer, ArrayList<Integer>> dependencyMap = new HashMap<>();
		HashSet<Integer> allJobs = new HashSet<>();
		HashSet<Integer> runningJobs = new HashSet<>();
		
		//Add all jobs into set
		for(int job : jobs)
			allJobs.add(job);
		
		//Prepare map for dependencies
		for(Integer[] d : deps) {
			
			if(!dependencyMap.containsKey(d[1]))
				dependencyMap.put(d[1], new ArrayList<Integer>());
			dependencyMap.get(d[1]).add(d[0]);
		}
		
		//Topological sort
		for(int i=0 ; i<jobs.size() ; i++) {
			if(exploreJob(jobs.get(i), allJobs, runningJobs, dependencyMap, result) == null)
				return new ArrayList<>();
		}
		
		return result;
	}
	
	private static ArrayList<Integer> exploreJob(int job, HashSet<Integer> allJobs, HashSet<Integer> runningJobs, HashMap<Integer, ArrayList<Integer>> dependencyMap, ArrayList<Integer> result) {
		
		if(runningJobs.contains(job))
			return null;
		
		if(!allJobs.contains(job))
			return result;
		
		allJobs.remove(job);
		runningJobs.add(job);
		
		if(!dependencyMap.containsKey(job)) {
			result.add(job);
			runningJobs.remove(job);
			return result;
		}
		
		for(int parent : dependencyMap.get(job)) {
			if(exploreJob(parent, allJobs, runningJobs, dependencyMap, result) == null)
				return null;
		}
		
		result.add(job);
		runningJobs.remove(job);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		/*ArrayList<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		ArrayList<Integer[]> deps = new ArrayList<>();
		
		deps.add(new Integer[]{3, 1});
		deps.add(new Integer[]{8, 1});
		deps.add(new Integer[]{8, 7});
		deps.add(new Integer[]{5, 7});
		deps.add(new Integer[]{5, 2});
		deps.add(new Integer[]{1, 4});
		deps.add(new Integer[]{1, 6});
		deps.add(new Integer[]{1, 2});
		deps.add(new Integer[]{7, 6});
		deps.add(new Integer[]{4, 6});
		deps.add(new Integer[]{6, 2});
		deps.add(new Integer[]{2, 3});*/
		
		ArrayList<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer[]> deps = new ArrayList<>();
		
		deps.add(new Integer[]{2, 1});
		deps.add(new Integer[]{4, 1});
		deps.add(new Integer[]{3, 2});
		deps.add(new Integer[]{4, 3});
		deps.add(new Integer[]{2, 4});
		
		ArrayList<Integer> result = topologicalSort(jobs, deps);
		
		System.out.println(result);
	}
}
