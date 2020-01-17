class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();    
            }
            
            buckets[frequency].add(entry.getKey());
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        
        return result;
    }
}