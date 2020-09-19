// TLE
// class Solution {
//     public int change(int amount, int[] coins) {
        
//         List<List<Integer>> result = new ArrayList<>();
//         helper(coins, 0, amount, new ArrayList<Integer>(), result);
//         return result.size();
//     }
    
//     private void helper(int[] coins, int startIndex, int target, List<Integer> combination, List<List<Integer>> result) {
//         if (target < 0) {
//             return;
//         }
        
//         if (target == 0) {
//             result.add(combination);
//             return;
//         }
        
//         for (int i = startIndex; i < coins.length; i++) {
//             combination.add(coins[i]);
//             helper(coins, i, target - coins[i], combination, result);
//             combination.remove(combination.size() - 1);
//         }
//     }
// }

class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}