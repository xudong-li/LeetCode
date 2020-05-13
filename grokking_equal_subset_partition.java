class PartitionSet {

  static boolean canPartition(int[] num) {
    //TODO: Write - Your - Code
    int sum = 0;
    for (int i : num) {
      sum += i;
    }

    if (sum % 2 != 0) {
      return false;
    }


    Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];

    return helper(dp, num, sum / 2, 0);
  }

  static boolean helper(Boolean[][] dp, int[] num, int sum, int currIndex) {
    if (sum == 0) {
      return true;
    }
    
    if (num.length == 0 || currIndex >= num.length) {
      return false;
    }

    // memorization
    if (dp[currIndex][sum] != null) {
      return dp[currIndex][sum];
    }

    // if the current number is less than the sum and we choose it
    if (num[currIndex] <= sum) {
      if (helper(dp, num, sum - num[currIndex], currIndex + 1)) {
        dp[currIndex][sum] = true;
        return true;
      }
    }
    // we skip the current number
    dp[currIndex][sum] = helper(dp, num, sum, currIndex + 1);

    return dp[currIndex][sum];

  }
}


