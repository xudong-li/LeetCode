class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public int missingNumber(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int index = nums[start];
            if (index < nums.length && index != nums[index]) {
                swap(nums, index, start);
            } else {
                start++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
}