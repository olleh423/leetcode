package problems;

public class BinaryReminder {

	public static int getReminderOfN(String value, int n) {
		
		if(value == null)
			return 0;
		
		int reminder = 0;
		
		for(int i=0 ; i<value.length() ; i++) {
			
			int digit = Integer.parseInt(String.valueOf(value.charAt(i)));
			reminder = ((reminder * 2) + (digit == 1 ? 1 : 0)) % n;
		}
		
		return reminder;
	}
	
	public static void main(String[] args) {
		
		String value = "101101110101";
		int n = 3;
		
		System.out.println("Reminder is : " + getReminderOfN(value, n));
	}
}
