package problems;

public class SingleCycleCheck {
	
	private static int getNextIndex(int currentIndex, int[] arr) {
		
		int jump = arr[currentIndex];
		int nextIndex = (currentIndex + jump) % arr.length;
		return nextIndex >= 0 ? nextIndex : nextIndex + arr.length;
	}
	
	public static boolean hasCycle(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return true;
		
		int visitedCount = 0;
		int currentIndex = 0;
		
		while(visitedCount < arr.length) {
			
			if(visitedCount > 0 && currentIndex == 0)
				return false;
			
			visitedCount++;
			currentIndex = getNextIndex(currentIndex, arr);
		}
		
		return currentIndex == 0;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 1, -4, -4, 2};
		System.out.println(hasCycle(arr));
	}
}
