package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class PartitionLabels {

    public static void main(String[] args) {

        PartitionLabels obj = new PartitionLabels();
        String S = "ababcbacadefegdehijhklij";
        System.out.println(obj.partitionLabels(S));
    }

    public List<Integer> partitionLabels(String str) {

        List<Integer> result = new ArrayList<>();

        if(str == null || str.isEmpty())
            return result;

        int[] lastIndex = new int[26];
        for(int i=0 ; i<str.length() ; i++) {
            lastIndex[str.charAt(i) - 'a'] = i;
        }

        for(int i=0 ; i<str.length() ; i++) {

            int end = lastIndex[str.charAt(i) - 'a'];
            int j = i;
            while(j < end) {
                end = Math.max(end, lastIndex[str.charAt(j++) - 'a']);
            }
            result.add(end - i + 1);
            i = j;
        }

        return result;
    }
}
