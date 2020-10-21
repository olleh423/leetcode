package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {

        SortCharactersByFrequency obj = new SortCharactersByFrequency();
        String s = "tree";
        System.out.println(obj.frequencySort(s));
    }

    public String frequencySort(String s) {

        if(s == null) return null;

        int[] count = new int[256];
        char[] chars = s.toCharArray();
        char[] result = new char[s.length()];

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> count[b]-count[a]);

        for(char ch : chars) count[ch]++;

        for(int i=0 ; i<count.length ; i++)
            if(i > 0) maxHeap.add((char) i);

        int i=0;
        while(! maxHeap.isEmpty()) {

            char ch = maxHeap.poll();
            while(count[ch] > 0) {
                result[i++] = ch;
                count[ch]--;
            }
        }

        return String.valueOf(result);
    }
}
