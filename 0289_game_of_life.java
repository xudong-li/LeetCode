class Solution {
    private int alive = 2;
    private int dead = 3;
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = countLives(i, j, board);
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = alive;
                } else if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = dead;
                    }
                    if (lives == 2 || lives == 3) {
                        continue;
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == alive) {
                    board[i][j] = 1;
                }
                if (board[i][j] == dead) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countLives(int x, int y, int[][] board) {
        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
        
        int lives = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (board[newX][newY] == 1 || board[newX][newY] == dead) {
                    lives++;
                }
            }
        }
        
        return lives;
    }
}