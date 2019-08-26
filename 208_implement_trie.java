class TrieNode {
    public boolean isString;
    public TrieNode[] children;
    
    public TrieNode() {
        isString = false;
        children = new TrieNode[26];
    }
}


class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (curr.children[position] == null) {
                curr.children[position] = new TrieNode();
            }
            curr = curr.children[position];
        }
        curr.isString = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (curr.children[position] == null) {
                return false;
            }
            curr = curr.children[position];
        }
        return curr.isString;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int position = prefix.charAt(i) - 'a';
            if (curr.children[position] == null) {
                return false;
            } else {
                curr = curr.children[position];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */