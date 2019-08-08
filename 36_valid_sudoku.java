class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[] visited = new boolean[9];
        
        //row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if(!processed(board[i][j], visited)) {
                    return false;
                }
            }
        }
        
        //col
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!processed(board[j][i], visited)) {
                    return false;
                }
            }
        }
        
        //sub-block
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!processed(board[i + k / 3][j + k % 3], visited)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean processed(char curr, boolean[] visited) {
        if (curr == '.') {
            return true;
        }
        
        int num = curr - '0';
        if (num < 1 || num > 9 || visited[num - 1]) {
            return false;
        }
        
        visited[num - 1] = true;
        
        return true;
    }
}