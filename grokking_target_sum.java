class TargetSum {

  public int findTargetSubsets(int[] num, int s) {
    // TODO: Write your code here
    
    int sum = 0;
    for (int i : num) {
      sum += i;
    }
    Integer[][] dp = new Integer[num.length][sum * 2 + 1];

    return helper(dp, num, s, 0, sum - s);
  }

  private int helper(Integer[][] dp, int[] num, int targetSum, int currIndex, int offset) {
    
    if (currIndex == num.length) {
      // if the sum is 0, then we have found a solution
      if (targetSum == 0) {
        return 1;
      }
      // out of index and we have not found a solution
      return 0;
    }

    // memorization
    if (dp[currIndex][targetSum + offset] != null) {
      return dp[currIndex][targetSum + offset];
    }

    // assign "+"
    int assignPlus = helper(dp, num, targetSum - num[currIndex], currIndex + 1, offset);
    
    // assign "-"
    int assignMinus = helper(dp, num, targetSum + num[currIndex], currIndex + 1, offset);

    dp[currIndex][targetSum + offset] = assignPlus + assignMinus;

    return dp[currIndex][targetSum + offset];

  }
  
  public static void main(String[] args) {
    TargetSum ts = new TargetSum();
    int[] num = {1, 1, 2, 3};
    System.out.println(ts.findTargetSubsets(num, 1));
    num = new int[]{1, 2, 7, 1};
    System.out.println(ts.findTargetSubsets(num, 9));
    num = new int[]{1, 1, 1, 1, 1};
    System.out.println(ts.findTargetSubsets(num, 3));
  }
}
