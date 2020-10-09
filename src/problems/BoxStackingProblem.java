package problems;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStackingProblem {

	private static class Box {
		
		int length, width, height, area;
		
		Box(int length, int width, int height) {
			
			this.length = length;
			this.width = width;
			this.height = height;
			
			this.area = length * width;
		}
	}
	
	public static int getPossibleLength(Box[] boxes) {
		
		int n = boxes.length;
		Box[] rotations = new Box[n*3];
		
		// Calculate all rotations of boxes
		int index = -1;
		for(int i=0 ; i<boxes.length ; i++) {
			
			rotations[++index] = new Box(Math.max(boxes[i].length, boxes[i].width), Math.min(boxes[i].length, boxes[i].width), boxes[i].height);
			rotations[++index] = new Box(Math.max(boxes[i].height, boxes[i].width), Math.min(boxes[i].height, boxes[i].width), boxes[i].length);
			rotations[++index] = new Box(Math.max(boxes[i].height, boxes[i].length), Math.min(boxes[i].height, boxes[i].length), boxes[i].width);
		}
		
		// Sort by area in descending order
		Arrays.sort(rotations, new Comparator<Box>() {
			@Override
			public int compare(Box one, Box two) {
				return new Integer(two.area).compareTo(new Integer(one.area));
			}
		});
		
		// calculate max possible height by stacking boxes using LIS(longest increasing subsequence).
		int[] heights = new int[rotations.length];
		int maxHeight = 0;
		
		for(int i=0 ; i<rotations.length ; i++) {
			heights[i] = rotations[i].height;
			maxHeight = heights[i] > maxHeight ? heights[i] : maxHeight;
		}
		
		for(int i=1 ; i<heights.length ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(rotations[i].length < rotations[j].length && rotations[i].width < rotations[j].width) {
					heights[i] = Math.max(heights[i], heights[j] + rotations[i].height);
					maxHeight = heights[i] > maxHeight ? heights[i] : maxHeight; 
				}
			}
		}

		return maxHeight;
	}
	
	public static void main(String[] args) {
		
		Box[] boxes = new Box[4];
		
		boxes[0] = new Box(4, 6, 7);
		boxes[1] = new Box(1, 2, 3);
		boxes[2] = new Box(4, 5, 6);
		boxes[3] = new Box(10, 12, 32);
		
		System.out.println("Maximum possible length : " + getPossibleLength(boxes));
	}
}
