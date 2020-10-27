package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MaximumNumberOfBalloons {

    public static void main(String[] args) {

        MaximumNumberOfBalloons obj = new MaximumNumberOfBalloons();
    }

    public int maxNumberOfBalloons(String text) {

        if(text == null)
            return 0;

        int totalUniqueChar = 5; // 5 unique chars are there in word "balloon"
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0 ; i<text.length() ; i++) {
            char ch = text.charAt(i);
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n')
                map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        if(map.size() < totalUniqueChar)
            return 0;

        map.put('l', map.get('l') / 2);
        map.put('o', map.get('o') / 2);

        int minInstances = Integer.MAX_VALUE;
        for(char ch : map.keySet()) {
            minInstances = Math.min(minInstances, map.get(ch));
        }

        return minInstances;
    }
}
