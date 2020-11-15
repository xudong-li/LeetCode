class Solution {
    public int minMoves(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minValue = Math.min(minValue, nums[i]);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (nums[i] - minValue);
        }
        
        return result;
    }
}