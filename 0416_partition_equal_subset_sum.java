class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
        
        return canPartitionRecursive(dp, nums, sum / 2, 0);
    }
    
    private boolean canPartitionRecursive(Boolean[][] dp, int[] nums, int sum, int currIndex) {
        if (sum == 0) {
            return true;
        }
        
        if (currIndex >= nums.length) {
            return false;
        }
        
        if (dp[currIndex][sum] != null) {
            return dp[currIndex][sum];
        }
        
        // include the number at currIndex
        if (nums[currIndex] <= sum) {
            if (canPartitionRecursive(dp, nums, sum - nums[currIndex], currIndex + 1)) {
                dp[currIndex][sum] = true;
                return true;
            }
        }
        
        // exclude the number at currIndex
        dp[currIndex][sum] = canPartitionRecursive(dp, nums, sum, currIndex + 1);
        
        return dp[currIndex][sum];
    }
}