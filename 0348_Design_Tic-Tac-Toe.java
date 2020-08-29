class TicTacToe {

    private int[] cols;
    private int[] rows;
    private int diag;
    private int antidiag;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        cols = new int[n];
        rows = new int[n];
        diag = 0;
        antidiag = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = 1;
        if (player == 2) {
            val = -1;
        }
        cols[col] += val;
        if (isFinished(cols[col])) {
            return cols[col] > 0 ? 1 : 2;
        }
        
        rows[row] += val;
        if (isFinished(rows[row])) {
            return rows[row] > 0 ? 1 : 2;
        }
        
        // diag
        if (row == col) {
            diag += val;
        }
        if (isFinished(diag)) {
            return diag > 0 ? 1 : 2;
        }
        
        //antidiag
        if (row + col == cols.length - 1) {
            antidiag += val;
        }
        if (isFinished(antidiag)) {
            return antidiag > 0 ? 1 : 2;
        }
        
        return 0;
    }
    
    private boolean isFinished(int val) {
        if (val == rows.length || -val == rows.length) {
            return true;
        }
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */