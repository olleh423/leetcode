package problems;

public class FirstNonRepeatingCharacter {
	
	private static class Count {
		
		int count, firstIndex;
		
		Count(int count, int firstIndex) {
			this.count = count;
			this.firstIndex = firstIndex;
		}
		
		void incrementCount() {
			this.count++;
		}
	}
	
	public int firstNonRepeating(String str) {
		
		Count[] count = new Count[256];
		
		for(int i=0 ; i<str.length() ; i++) {
			
			char ch = str.charAt(i);
			if(count[ch] == null)
				count[ch] = new Count(1, i);
			else
				count[ch].incrementCount();
		}
		
		int minIndex = Integer.MAX_VALUE;
		for(int i=0 ; i<count.length ; i++)
			if(count[i] != null && count[i].count == 1)
				minIndex = minIndex > count[i].firstIndex ? count[i].firstIndex : minIndex;
		
		return minIndex != Integer.MAX_VALUE ? minIndex : -1;
	}

	public int firstNonRepeatingChar(String s) {
	
		int[] count = new int[256];
		
		for(int i=0 ; i<s.length() ; i++)
			count[s.charAt(i)]++;
		
		for(int i=0 ; i<s.length() ; i++)
			if(count[s.charAt(i)] == 1)
				return i;
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		String s = "geeksforgeeksfirst";
		
		FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
		
		//int index = obj.firstNonRepeatingChar(s);
		int index = obj.firstNonRepeating(s);
		
		System.out.println(index != -1 ? s.charAt(index) : "Not found");
	}
}
