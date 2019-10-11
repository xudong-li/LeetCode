class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        for (int i = 0; i <= high;) {
            //  The problem about index i is that when you swap it to the end, nums[i] may become 0, which means u need to do one more swap before u update it. 
            if (nums[i] == 0) {
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                i++;
                low++;
            } else if (nums[i] == 2) {
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            } else {
                i++;
            }
        }
        
        return;
    }
}