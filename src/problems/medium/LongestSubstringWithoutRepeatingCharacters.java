package problems.medium;

/*
 * Auther : Vijay Sharma
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String str) {
        
        if(str == null || str.isEmpty())
            return 0;

        int n = str.length();
        int[] chars = new int[256];
        chars[str.charAt(0)] = 1;
        int i=0, j=0, result = 1;

        while(j < n-1) {

            char ch = str.charAt(j+1);
            if(chars[ch] == 0) {
                chars[ch]++;
                j++;
            }
            else {
                while(chars[ch] != 0) {
                    chars[str.charAt(i)]--;
                    i++;
                }
            }
            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
