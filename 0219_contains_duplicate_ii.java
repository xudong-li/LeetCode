class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (valueToIndexMap.containsKey(nums[i])) {
                if (Math.abs(valueToIndexMap.get(nums[i]) - i) <= k) return true;
            }
            valueToIndexMap.put(nums[i], i);
        }
        
        return false;
    }
}