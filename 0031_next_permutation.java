class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // 1. find the first smaller number from right
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp  = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}