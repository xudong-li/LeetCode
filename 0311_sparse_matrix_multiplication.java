class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        // A = m x k, B = k x n, C = m x n;
        
        int m = A.length, k = A[0].length, n = B[0].length;
        int[][] C = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int l = 0; l < n; l++) {
                    if (B[j][l] == 0) {
                        continue;
                    }
                    C[i][l] += A[i][j] * B[j][l];
                }
            }
        }
        
        return C;
    }
}