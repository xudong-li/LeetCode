class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    board[i][j] = (char) (k + '0');
                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        
        return true;
    }
    
public boolean isValid(char[][] board, int a, int b){
        Set<Character> contained = new HashSet<Character>();
        for(int i = 0; i < 9; i++){
            if(contained.contains(board[a][i]) && board[a][i] != '.') 
                return false;
            contained.add(board[a][i]);
        }
            
        
    
        contained = new HashSet<Character>();
        for(int i = 0; i < 9; i++){
            if (contained.contains(board[i][b]) && board[i][b] != '.') {
                return false;
            }
            contained.add(board[i][b]);
        }
        
    
        contained = new HashSet<Character>();
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++){
                int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
                if (contained.contains(board[x][y]) && board[x][y] != '.') {
                    return false;
                }
                contained.add(board[x][y]);
            } 
        }
    
        return true;
    }
}