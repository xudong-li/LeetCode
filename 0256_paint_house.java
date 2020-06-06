class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        
        for (int i = costs.length - 2; i >= 0; i--) {
            //cost of paint i th house as red;
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            
            //cost of paint i th house as blue;
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            
            //cost of paint i th house as green;
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}