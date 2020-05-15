class SubsetSum {
  static int countSubsets(int[] num, int sum) {
    //TODO: Write - Your - Code
    Integer dp[][] = new Integer[num.length][sum + 1];

    return helper(dp, num, sum, 0);
  }

  private static int helper(Integer[][] dp, int[] num, int sum, int currIndex) {
    if (sum == 0) {
      return 1;
    }
    
    if (currIndex >= num.length) {
      return 0;
    }

    if (dp[currIndex][sum] != null) {
      return dp[currIndex][sum];
    }

    int takeCurrIndex = 0;
    if (num[currIndex] <= sum) {
      takeCurrIndex = helper(dp, num, sum - num[currIndex], currIndex + 1);
    }

    int notTakeCurrIndex = helper(dp, num, sum, currIndex + 1);

    dp[currIndex][sum] = takeCurrIndex + notTakeCurrIndex;

    return dp[currIndex][sum];

  }

  public static void main(String[] args) {
    SubsetSum ss = new SubsetSum();
    int[] num = { 1, 1, 2, 3 };
    System.out.println(ss.countSubsets(num, 4));
    num = new int[] { 1, 2, 7, 1, 5 };
    System.out.println(ss.countSubsets(num, 9));
  }
}