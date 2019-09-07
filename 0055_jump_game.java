class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        if (nums.length == 1) {
            return true;
        }
        
        if (nums[0] == 0) {
            return false;
        }
        
        int[] dp = new int[nums.length];
        
        //dp records the maximum distance could just at position i. 
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] <= 0 && i < dp.length - 1) {
                return false;
            }
        }
        
        return true;
    }
}