package problems;


public class TrappingRainWater {

	public int getUnitOfWater(int[] bars) {
		
		int result = 0;
		int lMax = 0;
		int rMax = getRightMaxIndex(bars, 0);
		
		for(int i=1 ; i<bars.length-1 ; i++) {
			
			if(i == rMax) {
				lMax = i;
				rMax = getRightMaxIndex(bars, i+1);
			}
			else if(bars[i] >= bars[lMax]) {
				lMax = i;
			}
			else {
				result += (Math.min(bars[lMax], bars[rMax]) - bars[i]);
			}
		}
		
		return result;
	}
	
	private int getRightMaxIndex(int[] bars, int start) {
		
		int maxIndex = start;
		for(int i=start ; i<bars.length ; i++) {
			if(bars[maxIndex] < bars[i])
				maxIndex = i;
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		
		int[] bars = {3, 5, 4, 3, 2, 4, 3, 6, 3, 2, 4};
		//int[] bars = {3, 2, 1, 2, 5, 3, 4};
		
		TrappingRainWater trap = new TrappingRainWater();
		
		System.out.println("Total unit of water stored : " + trap.getUnitOfWater(bars));
	}
}
