class Solution {
    private int target;
    private int min_diff = Integer.MAX_VALUE;
    private int result;
    
    public int threeSumClosest(int[] nums, int target) {
        this.target = target;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            twoSum(nums, i + 1, nums.length - 1, nums[i]);
        }
        
        return result;
    }
    
    private void twoSum(int[] nums, int left, int right, int num_i) {
        
        while (left < right) {
            if (Math.abs(nums[left] + nums[right] + num_i - target) < min_diff) {
                min_diff = Math.abs(nums[left] + nums[right] + num_i - target);
                result = nums[left] + nums[right] + num_i;
                
            } else if (nums[left] + nums[right] + num_i < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return;
    }
}