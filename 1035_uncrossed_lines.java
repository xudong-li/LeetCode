class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        
        int[][] dp = new int[A.length][B.length];
        int flag = 0;
        
        for (int i = 0; i < dp.length; i++) {
            if (B[0] == A[i]) {
                flag = 1;
            }
            dp[i][0] = flag;
        }
        
        flag = 0;
        for (int i = 0; i < dp[0].length; i++) {
            if (A[0] == B[i]) {
                flag = 1;
            }
            dp[0][i] = flag;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], 
                                            Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], 
                                        Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}