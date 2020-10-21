package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        GroupAnagrams obj = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(obj.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        if(strs == null)
            return result;

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String newString = String.valueOf(chars);

            if(!map.containsKey(newString))
                map.put(newString, new ArrayList<>());

            map.get(newString).add(s);
        }

        for(String key : map.keySet())
            result.add(map.get(key));

        return result;
    }
}
