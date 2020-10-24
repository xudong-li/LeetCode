class Solution {
    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(click);
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int mines = getMines(board, curr);
            if (mines == -1) {
                board[curr[0]][curr[1]] = 'X';
                return board;
            } else if (mines == 0) {
                board[curr[0]][curr[1]] = 'B';
                for (int i = 0; i < 8; i++) {
                    int newX = curr[0] + dx[i];
                    int newY = curr[1] + dy[i];
                    if (isValid(board, newX, newY) && board[newX][newY] == 'E') {
                        board[newX][newY] = '0'; //mask to prevent infinite loop
                        q.offer(new int[]{newX, newY});
                    }
                }
            } else {
                board[curr[0]][curr[1]] = (char)('0' + mines);
            }
        }
        
        return board;
    }
    
    private boolean isValid(char[][] board, int newX, int newY) {
        if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
            return true;
        }
        return false;
    }
    
    private int getMines(char[][] board, int[] curr) {
        if (board[curr[0]][curr[1]] == 'M') {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = curr[0] + dx[i];
            int newY = curr[1] + dy[i];
            if (isValid(board, newX, newY) && board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;
    }
}




