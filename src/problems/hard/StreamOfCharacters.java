package problems.hard;

public class StreamOfCharacters {

    public static void main(String[] args) {

        String[] arr = {"cd","f","kl"};

        StreamOfCharacters obj = new StreamOfCharacters(arr);
        obj.query('a');          // return false
        obj.query('b');          // return false
        obj.query('c');          // return false
        obj.query('d');          // return true, because 'cd' is in the wordlist
        obj.query('e');          // return false
        obj.query('f');          // return true, because 'f' is in the wordlist
        obj.query('g');          // return false
        obj.query('h');          // return false
        obj.query('i');          // return false
        obj.query('j');          // return false
        obj.query('k');          // return false
        obj.query('l');          // return true, because 'kl' is in the wordlist
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }

        public TrieNode get(char ch) {
            return children[ch-'a'];
        }
        public void put(char ch, TrieNode node) {
            children[ch-'a'] = node;
        }
    }

    private TrieNode root;
    private StringBuilder sb;

    public StreamOfCharacters(String[] words) {

        root = new TrieNode();
        sb = new StringBuilder();
        for(String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {

        sb.append(letter);
        return search(sb);
    }

    private void insert(String word) {

        TrieNode current = root;
        for(int i=word.length()-1 ; i>=0 ; i--) {
            char ch = word.charAt(i);
            TrieNode node = current.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    private boolean search(StringBuilder word) {

        TrieNode current = root;
        for(int i=word.length()-1 ; i>=0 ; i--) {
            char ch = word.charAt(i);
            TrieNode node = current.get(ch);
            if(node == null) return false;
            if(node.endOfWord) return true;
            current = node;
        }
        return current.endOfWord;
    }
}
