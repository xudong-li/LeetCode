class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean isStable = true;
        int R = board.length, C = board[0].length;
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C - 2; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
                    isStable = false;
                }
            }
        }
        
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R - 2; r++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
                    isStable = false;
                }
            }
        }
        
        for (int c = 0; c < C; c++) {
            int writePointer = R - 1;
            for (int r = R - 1; r >= 0; r--) {
                if (board[r][c] > 0) {
                    board[writePointer][c] = board[r][c];
                    writePointer--;
                }
            }
            while (writePointer >= 0) {
                board[writePointer][c] = 0;
                writePointer--;
            }
        }
        
        return !isStable ? candyCrush(board) : board;
    }
}