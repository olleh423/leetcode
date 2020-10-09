package problems;

/*
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

	If there is no solution possible, return -1.
	
	Example :
	
	A : [3 5 4 2]
	
	Output : 2 
	for the pair (3, 4)
 * 
 */

public class MaxDistance {

	public static int maximumGap(final int[] arr) {
        
        int[] lMin = new int[arr.length];
        int[] rMax = new int[arr.length];
        
        lMin[0] = arr[0];
        for(int i=1 ; i<arr.length ; i++)
            lMin[i] = Math.min(lMin[i-1], arr[i]);
        
        rMax[arr.length-1] = arr[arr.length-1];
        for(int j=arr.length-2 ; j>=0 ; j--)
            rMax[j] = Math.max(arr[j], rMax[j+1]);
            
        int i = 0, j = 0, maxDiff = 0; 
        while (j < arr.length && i < arr.length) {
            if (lMin[i] <= rMax[j]) {
                maxDiff = Math.max(maxDiff, j - i); 
                j = j + 1; 
            }  
            else 
                i = i + 1; 
        } 
  
        return maxDiff; 
    }
	
	public static void main(String[] args) {
		
		int[] arr = {46158044, 9306314, 51157916, 93803496, 20512678, 55668109, 488932, 24018019, 91386538, 68676911, 92581441, 66802896, 10401330, 57053542, 42836847, 24523157, 50084224, 16223673, 18392448, 61771874, 75040277, 30393366, 1248593, 71015899, 20545868, 75781058, 2819173, 37183571, 94307760, 88949450, 9352766, 26990547, 4035684, 57106547, 62393125, 74101466, 87693129, 84620455, 98589753, 8374427, 59030017, 69501866, 47507712, 84139250, 97401195, 32307123, 41600232, 52669409, 61249959, 88263327, 3194185, 10842291, 37741683, 14638221, 61808847, 86673222, 12380549, 39609235, 98726824, 81436765, 48701855, 42166094, 88595721, 11566537, 63715832, 21604701, 83321269, 34496410, 48653819, 77422556, 51748960, 83040347, 12893783, 57429375, 13500426, 49447417, 50826659, 22709813, 33096541, 55283208, 31924546, 54079534, 38900717, 94495657, 6472104, 47947703, 50659890, 33719501, 57117161, 20478224, 77975153, 52822862, 13155282, 6481416, 67356400, 36491447, 4084060, 5884644, 91621319, 43488994, 71554661, 41611278, 28547265, 26692589, 82826028, 72214268, 98604736, 60193708, 95417547, 73177938, 50713342, 6283439, 79043764, 52027740, 17648022, 33730552, 42851318, 13232185, 95479426, 70580777, 24710823, 48306195, 31248704, 24224431, 99173104, 31216940, 66551773, 94516629, 67345352, 62715266, 8776225, 18603704, 7611906};
		System.out.println(maximumGap(arr));
	}
}
