class Solution {
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return result;
        }
        
        helper(n, new ArrayList<Integer>());
        return result;
    }
    
    // cols stores position of the queens. index is row number and value is col number.
    private void helper(int n, List<Integer> cols) {
        if (cols.size() == n) {
            result.add(drawChessBoard(cols));
            return;
        }
        
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            helper(n, cols);
            cols.remove(cols.size() - 1);
        }
    }
    
    // queens are already placed in cols, and column is the current column we are going to check
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            //diag x + y
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            //diag x - y
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> drawChessBoard(List<Integer> cols) {
        List<String> chessBoard = new ArrayList<String>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessBoard.add(sb.toString());
        }
        return chessBoard;
    }
}




