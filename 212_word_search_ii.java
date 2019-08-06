// TireTree version

class TrieNode {
    String word;
    Map<Character, TrieNode> children;
    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
};


class TrieTree{
    TrieNode root;
    
    public TrieTree(TrieNode TrieNode) {
        root = TrieNode;
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            } 
            node = node.children.get(word.charAt(i));
        }
        node.word = word;
    }
};


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) {
            return new ArrayList<String>();
        }
        
        TrieTree tree = new TrieTree(new TrieNode());
        for (String word : words) {
            tree.insert(word);
        }
        
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, tree.root, results);
            }
        }
        
        return results;
    }
    
    private void search(char[][] board, int x, int y, TrieNode root, List<String> results) {
        if (!root.children.containsKey(board[x][y])) {
            return;
        }
        
        TrieNode child = root.children.get(board[x][y]);
        
        if (child.word != null) {
            if (!results.contains(child.word)) {
                results.add(child.word);
            }
        }
        
        char temp = board[x][y];
        board[x][y] = '#';
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                search(board, newX, newY, child, results);
            }
            
        }
        
        board[x][y] = temp;
        
    }
};




//DFS version

class Solution {
    private Set<String> result = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) {
            return new ArrayList<String>(result);
        }
        
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == words[k].charAt(0)) {
                        if (wordSearch(board, words[k], i, j, 0)) {
                            result.add(words[k]);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<String>(result);
    }
    
    private boolean wordSearch(char[][] board, String word, int x, int y, int start) {
        if (start == word.length()) {
            return true;
        }
        
        if (x < 0 || x >= board.length || 
            y < 0 || y >= board[0].length || 
            board[x][y] != word.charAt(start)) {
            return false;
        }
        
        board[x][y] = '#';
        boolean result = wordSearch(board, word, x + 1, y, start + 1) ||
                         wordSearch(board, word, x, y + 1, start + 1) ||
                         wordSearch(board, word, x - 1, y, start + 1) ||
                         wordSearch(board, word, x, y - 1, start + 1);
        
        board[x][y] = word.charAt(start);
        
        return result;
    }
}


