class Knapsack {

  static int solveKnapsack(int[] profits, int[] weights, int capacity) {
    //TODO: Write - Your - Code
    int dp[][] = new int[weights.length][capacity + 1];

    for (int i = 0; i < dp.length; i++) {
      // if the capacity is 0, then the profit is 0;
      dp[i][0] = 0; 
    }

    // if the first weight is less than the current capcacity, then put the profits
    for (int c = 0; c <= capacity; c++) {
      if (weights[0] <= c) {
        dp[0][c] = profits[0];
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int c = 1; c <= capacity; c++) {
        int profit1 = 0, profit2 = 0;

        // if we take this item i at capcaity c;
        if (weights[i] <= c) {
          profit1 = profits[i] + dp[i - 1][c - weights[i]];
        }
        
        // if we do not take this item i, then the profit is the previous one;
        profit2 = dp[i-1][c];

        dp[i][c] = Math.max(profit1, profit2);
      }
    }

    return dp[weights.length - 1][capacity];
  }
}