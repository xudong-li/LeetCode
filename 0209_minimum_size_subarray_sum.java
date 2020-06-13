class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int result = Integer.MAX_VALUE;
        int windowStart = 0;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];
            while (sum >= s) {
                result = Math.min(result, windowEnd - windowStart + 1);
                sum -= nums[windowStart];
                windowStart++;
            }
        }
        
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        
        return result;
    }
}