class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i < n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        
        return dp[(n - 1) % 3];
    }
}