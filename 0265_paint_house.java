class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int previousColor = 0; previousColor < costs[0].length; previousColor++) {
                    if (j == previousColor) {
                        continue;
                    }
                    min = Math.min(min, costs[i - 1][previousColor]);
                }
                costs[i][j] += min; //the dp cost = current cost + min of previous color;
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            result = Math.min(result, costs[costs.length - 1][i]);
        }
        
        return result;
    }
}