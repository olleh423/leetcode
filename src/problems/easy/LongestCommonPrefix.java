package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(obj.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        String lcp = "";
        if(strs == null || strs.length == 0)
            return lcp;

        lcp = strs[0];
        for(int i=1 ; i<strs.length ; i++) {

            String s = strs[i];
            StringBuilder builder = new StringBuilder();
            if(s.length() > lcp.length()) {
                for(int j=0 ; j<lcp.length() ; j++) {
                    if(s.charAt(j) != lcp.charAt(j)) {
                        break;
                    }
                    builder.append(s.charAt(j));
                }
                if(builder.length() == 0)
                    return "";
                else
                    lcp = builder.toString();
            } else {
                for(int j=0 ; j<s.length() ; j++) {
                    if(s.charAt(j) != lcp.charAt(j)) {
                        break;
                    }
                    builder.append(s.charAt(j));
                }
                if(builder.length() == 0)
                    return "";
                else
                    lcp = builder.toString();
            }
        }
        return lcp;
    }
}
