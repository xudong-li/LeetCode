class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] dp = new int[2];
        
        for (int i = n - 1; i >= n - k; i--) {
            dp[0] += cardPoints[i];
        }
        
        int result = dp[0];
        for (int i = 1; i < k + 1; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + cardPoints[i - 1] - cardPoints[n - k + i - 1];
            result = Math.max(result, dp[i % 2]);
        }
        
        return result;
    }
}