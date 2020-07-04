class Solution {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        int m = matrix.length;
        if (m == 0) return 0;
        
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, memo));
            }
        }
        
        return result;
    }
    
    private int dfs(int[][] matrix, int x, int y, int[][] memo) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        
        int length = 0;
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length 
                && matrix[newX][newY] > matrix[x][y]) {
                length = Math.max(length, dfs(matrix, newX, newY, memo));        
            }
        }
        
        memo[x][y] = length + 1;
        return length + 1;
    }
}

