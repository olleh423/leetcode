package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class DesignAddAndSearchWordDataStructure {

    public static void main(String[] args) {

        DesignAddAndSearchWordDataStructure obj = new DesignAddAndSearchWordDataStructure();
    }

    private static class Trie {
        Map<Character, Trie> children;
        boolean endOfWord;
        Trie() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private Trie root;

    /** Initialize your data structure here. */
    public DesignAddAndSearchWordDataStructure() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        Trie current = root;
        for(int i=0 ; i<word.length() ; i++) {
            char ch = word.charAt(i);
            Trie node = current.children.get(ch);
            if(node == null) {
                node = new Trie();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    boolean search(String word, int idx, Trie current) {

        if(idx == word.length())
            return current.endOfWord;

        char ch = word.charAt(idx);
        if(ch == '.') {
            for(char key : current.children.keySet()) {
                if(search(word, idx+1, current.children.get(key)))
                    return true;
            }
        }
        else {
            Trie node = current.children.get(ch);
            return node == null ? false : search(word, idx+1, node);
        }

        return false;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
}
