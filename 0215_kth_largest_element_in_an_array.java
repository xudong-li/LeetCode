class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        while (start <= end) {
            int pivot = partition(nums, start, end);
            if (pivot == nums.length - k) {
                return nums[pivot];
            } else if (pivot > nums.length - k) {
                return quickSelect(nums, start, pivot - 1, k);
            } else {
                return quickSelect(nums, pivot + 1, end, k);
            }
        }
        return -1;
    }
    
    private int partition(int[] nums, int start, int end) {
        int i = start + 1, j = end;
        while (true) {
            // use nums[start] as our target
            while (i <= end && nums[i] < nums[start]) {
                i++;
            }
            while (j >= start + 1 && nums[j] > nums[start]) {
                j--;
            }
            if (i > j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        
        //swap j with target
        int temp = nums[start];
        nums[start] = nums[j];
        nums[j] = temp;
        return j;
    }
}