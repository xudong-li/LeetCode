class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int maxGap = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxGap = Math.max(maxGap, entry.getValue());    
        }
        
        return wall.size() - maxGap;
    }
}