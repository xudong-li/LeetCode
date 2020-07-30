class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currKey = entry.getKey();
            int currValue = entry.getValue();
            if (currValue > 0) {
                for (int i = 0; i < k; i++) {
                    if (map.containsKey(currKey + i)) {
                        map.put(currKey + i, map.get(currKey + i) - currValue);
                        if (map.get(currKey + i) < 0) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}