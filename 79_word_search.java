class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (wordSearch(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean wordSearch(char[][] board, 
                               String word, 
                               int x, int y, 
                               int start) {
        
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