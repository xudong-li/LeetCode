class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean foundOne = false;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                foundOne = true;
            }
            if (nums[i] > n || nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        if (!foundOne) {
            return 1;
        }
        
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]) - 1;
            nums[a] = - Math.abs(nums[a]);
             
        }
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // this means there is no positive num, the result is n + 1
        return n + 1;
    }
}