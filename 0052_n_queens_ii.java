class Solution {
    private int result = 0;
    
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        
        helper(n, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int n, List<Integer> cols) {
        if (cols.size() == n) {
            result++;
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
    
    private boolean isValid(List<Integer> cols, int colIndex) {
        int row = cols.size();
        
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (cols.get(rowIndex) == colIndex) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + colIndex) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - colIndex) {
                return false;
            }
        }
        
        return true;
    }
}