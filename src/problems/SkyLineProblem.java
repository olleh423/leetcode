package problems;

import java.util.ArrayList;
import java.util.List;

public class SkyLineProblem {

	private static class Building {
		
		int i, j, h;
		
		Building(int i, int j, int h) {
			
			this.i = i;
			this.j = j;
			this.h = h;
		}
	}
	
	private static class Result {
		
		int i, h;
		
		Result(int i, int h) {
			this.i = i;
			this.h = h;
		}
	}
	
	public List<Result> skylineProblem(List<Building> input) {
		
		List<Result> results = new ArrayList<>();
		
		//TODO
		
		return results;
	}
	
	public static void main(String[] args) {
		
		List<Building> input = new ArrayList<>();
		
		input.add(new Building(2, 9, 10));
		input.add(new Building(3, 6, 15));
		input.add(new Building(5, 12, 12));
		input.add(new Building(13, 16, 10));
		input.add(new Building(13, 16, 10));
		input.add(new Building(15, 17, 5));
		
		SkyLineProblem obj = new SkyLineProblem();
		
		List<Result> results = obj.skylineProblem(input);
		
		for(Result res : results) {
			System.out.println(res.i + " -- " + res.h);
		}
	}
}
