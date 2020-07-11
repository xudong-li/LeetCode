class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // map<id, list<id> children> map;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<Integer>());
            }
            map.get(manager[i]).add(i);
        }
        
        return dfs(map, informTime, headID);
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int[] informTime, int currId) {
        if (!map.containsKey(currId)) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < map.get(currId).size(); i++) {
            max = Math.max(max, dfs(map, informTime, map.get(currId).get(i)));
        }
        
        return max + informTime[currId];
    }
}