package problems;

public class KangarooJump {

	public static String yesOrNo(int p1, int u1, int p2, int u2) {
        
        int diff = Math.abs(p1 - p2);
        do {
            System.out.println(diff);
            int a = p1 + u1;
            int b = p2 + u2;
            int newDiff = Math.abs(a-b);
            if(newDiff >= diff) {
                return "No";
            } else {
                diff = newDiff;
                p1 = a;
                p2 = b;
            }            
        } while(diff != 0);
        
        return "Yes";
    }
	
	public static void main(String[] args) {
		
		System.out.println(yesOrNo(43, 2, 70, 2));
	}
}
