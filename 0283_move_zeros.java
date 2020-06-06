class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int lastNonZeroFoundAt = 0, curr = 0; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                swap(nums, lastNonZeroFoundAt++, curr);
            }
        }
        return;
    }
    
    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
        return;
    }
}