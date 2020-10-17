package problems.medium;

import java.util.*;

/*
 * Auther : Vijay Sharma
 */
public class WordLadder {

    public static void main(String[] args) {

        WordLadder obj = new WordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord == null || endWord == null || beginWord.length() != endWord.length())
            return 0;

        Set<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);

        if(!words.contains(endWord))
            return 0;

        int length = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0 ; i<size ; i++) {

                String str = queue.poll();
                if(str.equals(endWord))
                    return length;

                match(str, words, visited, queue);
            }
            length++;
        }

        return 0;
    }

    private void match(String word, Set<String> wordSet, Set<String> visited, Queue<String> queue) {

        char[] chars = word.toCharArray();
        for(int i=0 ; i<chars.length ; i++) {
            char ch = chars[i];
            for(int j=0 ; j<26 ; j++) {
                chars[i] = (char)(j + 'a');
                String newWord = String.valueOf(chars);
                if(wordSet.contains(newWord) && !visited.contains(newWord)) {
                    visited.add(newWord);
                    queue.add(newWord);
                }
            }
            chars[i] = ch;
        }
    }
}
