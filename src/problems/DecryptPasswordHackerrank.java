package problems;

public class DecryptPasswordHackerrank {
	
	private static String decrypt(String pass) {
		
		if(pass == null) 
			return null;
		
		StringBuilder builder = new StringBuilder("");
		
		int i = 0;
		int j = pass.length() - 1;
		
		while(j >= i) {
			
			char ch = pass.charAt(j);
			
			if(ch == '*') {
				builder.append(pass.charAt(j-2));
				builder.append(pass.charAt(j-1));
				j -= 3;
			}
			else if(ch == '0') {
				builder.append(pass.charAt(i));
				i++; j--;
			}
			else {
				builder.append(ch);
				j--;
			}
		}

		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		
		String password = "51Pa*0Lp*0e";		// "43Ah*ck0rr0nk"
	
		System.out.println(decrypt(password));
	}
}
