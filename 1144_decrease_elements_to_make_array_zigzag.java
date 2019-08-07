// make nums[odd] or nums[even] smaller
// look at nums[i - 1] and nums[i + 1]


class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int left = 0, right = 0;
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            right = i < nums.length - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            // if it is less than 0, that means it is already zigzag... 
            result[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1); 
        }
        
        return Math.min(result[0], result[1]);
    }
}