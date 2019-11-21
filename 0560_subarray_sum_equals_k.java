class Solution {
    public int subarraySum(int[] nums, int k) {
        // [1,2,3] --> [0,1,3,6]   sum from [i,j] --> arraysum [j + 1] - arraysum [i];
        // int[] preSum = new int[nums.length + 1];
        // preSum[0] = 0;
        // for (int i = 1; i < preSum.length; i++) {
        //     preSum[i] = nums[i - 1] + preSum[i - 1];
        // }
        
        Map<Integer, Integer> preSumMap = new HashMap<>();
        
        // base case for preSum;
        preSumMap.put(0, 1);
        
        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSumMap.containsKey(sum - k)) {
                result += preSumMap.get(sum - k);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}