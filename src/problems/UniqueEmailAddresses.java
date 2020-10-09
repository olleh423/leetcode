package problems;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 * Leetcode 929
 */
public class UniqueEmailAddresses {

	public int uniqueEmailAddresses(String[] emails) {
		
		if(emails == null || emails.length == 0)
			return 0;
		
		Set<String> set = new HashSet<>();
		for(String email : emails) {
			
			int atIndex = email.indexOf('@');
            int firstPlus = email.indexOf('+');

            StringBuilder address = new StringBuilder();
            if(firstPlus != -1) {
                address.append(email.substring(0, firstPlus).replaceAll("\\.", ""));
            } else {
            	address.append(email.substring(0, atIndex).replaceAll("\\.", ""));
            }
            address.append(email.substring(atIndex));
            set.add(address.toString());
		}
		
		return set.size();
	}
	
	public static void main(String[] args) {
		
		//String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		//String[] emails = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
		String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		
		UniqueEmailAddresses obj = new UniqueEmailAddresses();
		
		System.out.println(obj.uniqueEmailAddresses(emails));
	}
}
