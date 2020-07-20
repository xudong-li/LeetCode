class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
        }
        int right = Arrays.stream(nums).sum();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canSplit(int[] nums, int m, int mid) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}