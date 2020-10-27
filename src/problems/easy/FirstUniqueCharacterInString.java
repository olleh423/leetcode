package problems.easy;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FirstUniqueCharacterInString {

    public static void main(String[] args) {

        FirstUniqueCharacterInString obj = new FirstUniqueCharacterInString();
    }

    public int firstUniqChar(String s) {

        if(s == null) return 0;

        int[] chars = new int[26];
        for(int i=0 ; i<s.length() ; i++) {
            int ch = s.charAt(i);
            chars[ch - 'a']++;
        }

        for(int i=0 ; i<s.length() ; i++) {
            int ch = s.charAt(i);
            if(chars[ch - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
