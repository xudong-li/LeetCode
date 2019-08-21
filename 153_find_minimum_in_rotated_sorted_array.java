class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        int lastElement = nums[nums.length - 1];
        
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < lastElement) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}