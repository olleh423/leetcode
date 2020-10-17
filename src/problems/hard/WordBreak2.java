package problems.hard;

import java.util.*;

public class WordBreak2 {

    public static void main(String[] args) {

        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        WordBreak2 obj = new WordBreak2();
        System.out.println(obj.wordBreak(s, wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        if(s == null || wordDict == null)
            return null;

        return solve(s, 0, new HashSet<String>(wordDict), new HashMap<Integer, List<String>>());
    }

    private List<String> solve(String s, int idx, Set<String> dict, Map<Integer, List<String>> map) {

        if(map.containsKey(idx))
            return map.get(idx);

        List<String> result = new ArrayList<>();

        if(idx == s.length())
            result.add("");

        for(int i=idx+1 ; i<=s.length(); i++) {
            String prefix = s.substring(idx, i);
            if(dict.contains(prefix)) {
                List<String> suffixes = solve(s, i, dict, map);
                for(String suffix : suffixes) {
                    result.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
                }
            }
        }

        map.put(idx, result);
        return result;
    }
}
