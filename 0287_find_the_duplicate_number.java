class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        //now fast = slow, and then we need to find the intersection
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}