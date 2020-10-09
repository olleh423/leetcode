package problems;

public class FirstAndLastPositionInSortedArray {

	public int[] searchRange(int[] nums, int target) {
     
		if(nums == null || nums.length == 0)
			return null;
		
		int[] positions = new int[2];
		
		positions[0] = getLeftMostIndex(nums, target);
		positions[1] = getRightMostIndex(nums, target);
		
		return positions;
	}
	
	private int getLeftMostIndex(int[] nums, int target) {
		
		int i = 0;
		int j = nums.length - 1;
		
		int index = -1;
		while(i <= j) {
			
			int mid = (i + j) / 2;
			if(nums[mid] == target) {
				index = mid;
				j = mid - 1;
			} else if(nums[mid] < target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return index;
	}
	
	private int getRightMostIndex(int[] nums, int target) {
		
		int i = 0;
		int j = nums.length - 1;
		
		int index = -1;
		while(i <= j) {
			
			int mid = (i + j) / 2;
			if(nums[mid] == target) {
				index = mid;
				i = mid + 1;
			} else if(nums[mid] < target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return index;
	}
    
    public static void main(String[] args) {
    	
    	int[] nums = {1, 2, 2, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 9, 9, 9, 9};
    	int target = 9;
    	
    	FirstAndLastPositionInSortedArray obj = new FirstAndLastPositionInSortedArray();
    	
    	int[] positions = obj.searchRange(nums, target);
    	
    	System.out.println(positions[0] + " : " + positions[1]);
    }
}
