package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	private void generate(int n, int m, String result, List<String> data) {
		
		if(n == 0 && m == 0) {
			data.add(result);
			return;
		}
		
		if(n != 0)
			generate(n - 1, m, result + "(", data);
		
		if(n < m)
			generate(n, m - 1, result + ")", data);
	}
	
	public List<String> generate(int n) {
		
		List<String> data = new ArrayList<String>();
		
		generate(n, n, "", data);
		
		return data;
	}

	public static void main(String[] args) {
		
		int n = 3;
		
		GenerateParentheses obj = new GenerateParentheses();
		
		List<String> parentheses = obj.generate(n);
		
		System.out.println(parentheses);
	}
}
