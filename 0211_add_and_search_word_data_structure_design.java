class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord = false;
}

class WordDictionary {

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
        return;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchRecursive(word.toCharArray(), 0, root);
    }
    
    private boolean searchRecursive(char[] wordChars, int index, TrieNode node) {
        if (index == wordChars.length) {
            return node.isWord;
        }
        if (wordChars[index] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (searchRecursive(wordChars, index + 1, node.children[i])) {
                        return true;
                    };
                }
            }
        } else {
            if (node.children[wordChars[index] - 'a'] != null) {
                return searchRecursive(wordChars, index + 1, node.children[wordChars[index] - 'a']);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */