package problems;

public class StringPermutation {

	private String swap(int i, int j, String s) {
		
		StringBuffer sb = new StringBuffer(s);
		char ch = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, ch);
		return sb.toString();
	}
	
	private static int count = 1;
	
	private void permute(int i, int j, String s) {
		
		if(i == s.length()-1) {
			System.out.println(count + " : " + s);
			count++;
			return;
		}
		
		for(int k=j ; k<s.length() ; k++) {
			s = swap(i, k, s);
			permute(i+1, i+1, s);
			s = swap(i, k, s);
		}
	}
	
	public void permute(String s) {
		permute(0, 0, s);
	}
	
	public static void main(String[] args) {
	
		StringPermutation sp = new StringPermutation();
		sp.permute("ABCD");
	}
}
