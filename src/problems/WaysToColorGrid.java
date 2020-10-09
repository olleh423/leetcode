package problems;

public class WaysToColorGrid {

	/*
	 * This method is calculating number of ways to paint a 3xA grid with 4 maximum colors 
	 * such that no adjacent cell have same color
	 */
	public static int solve(int A) {
		
        long color3 = 24; // When we to fill single column
        long color2 = 12;
        long temp = 0;
        for (int i = 2; i <= A; i++)        
        {
            temp = color3;
            color3 = (11 * color3 + 10 * color2 ) % 1000000007;
            color2 = ( 5 * temp + 7 * color2 ) % 1000000007;
        }
        long num = (color3 + color2) % 1000000007;
     
        return (int)num;
    }
	
	public static void main(String[] args) {
		
		System.out.println(solve(2));
	}
}
