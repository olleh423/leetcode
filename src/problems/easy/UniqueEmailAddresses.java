package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class UniqueEmailAddresses {

    public static void main(String[] args) {

        UniqueEmailAddresses obj = new UniqueEmailAddresses();

        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(obj.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {

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
}
