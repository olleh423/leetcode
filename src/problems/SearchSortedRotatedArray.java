package problems;

public class SearchSortedRotatedArray {
	
	private static int getPivot(int[] arr, int s, int e) {
		
		if(s == e) 
			return s;
		
		int m = (s + e) / 2;
		
		if(arr[m+1] < arr[m])
			return m+1;
		
		return arr[s] > arr[m] ? getPivot(arr, s, m-1) : getPivot(arr, m+1, e);
	}

	public static void search(int[] arr, int x) {
		
		int s = 0, e = arr.length - 1;
		boolean found = false;

		int pivot = 0;
        if(arr[s] > arr[e])
            pivot = getPivot(arr, s, e);
		
		if(x >= arr[pivot] && x <= arr[e])
			s = pivot;
		else
			e = pivot-1;
		
		while(s < e) {
			
			int m = (s + e) / 2;
			
			if(arr[m] == x) {
				System.out.println("Element found at " + m + " index.");
				found = true;
				break;
			}
			
			if(x < arr[m])
				e = m-1;
			else
				s = m+1;
		}
		
		if(!found)
			System.out.println("Element not found.");
	}
	
	public static void main(String[] args) {
		
		int[] arr = {192, 194, 197, 198, 199, 200, 201, 203, 204, 2, 3, 4, 7, 9, 10, 11, 14, 15, 16, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 33, 34, 35, 36, 39, 40, 42, 43, 46, 47, 50, 51, 52, 53, 55, 57, 59, 60, 64, 66, 68, 70, 71, 72, 75, 76, 78, 85, 86, 87, 91, 92, 94, 95, 96, 99, 102, 105, 106, 107, 109, 111, 113, 114, 115, 119, 120, 121, 123, 125, 129, 130, 131, 133, 134, 137, 138, 139, 140, 141, 142, 143, 145, 146, 149, 151, 152, 156, 160, 161, 165, 167, 168, 170, 171, 176, 177, 178, 179, 180, 181, 182, 185, 186, 190};
		//int[] arr = {180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 198, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177};
		//int[] arr = {9, 10, 11, 12, 14, 15, 17, 19, 24, 25, 30, 39, 40, 44, 46, 48, 51, 53, 54, 56, 59, 60, 69, 70, 73, 75, 80, 87, 88, 89, 92, 93, 97, 99, 104, 107, 109, 110, 111, 117, 123, 124, 125, 126, 127, 128, 135, 136, 137, 141, 148, 153, 154, 161, 166, 167, 169, 175, 177, 180, 181, 182, 185, 186, 189, 193, 198, 202, 1, 2, 6, 7};
		search(arr, 70);
	}
}