class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, n / 2) 
                    + findKth(nums1, 0, nums2, 0, n / 2 + 1)) 
                    / 2.0;
        }
        return (double) findKth(nums1, 0, nums2, 0, n / 2 + 1);
    }
    
    private int findKth(int[] nums1, int startOfNums1, 
                        int[] nums2, int startOfNums2, 
                        int k) {
        
        if (startOfNums1 >= nums1.length) {
            return nums2[startOfNums2 + k - 1];
        }
        
        if (startOfNums2 >= nums2.length) {
            return nums1[startOfNums1 + k - 1];
        }
        
        
        if (k == 1) {
            return Math.min(nums1[startOfNums1], nums2[startOfNums2]);
        }
        
        
        int halfKthOfNums1 = startOfNums1 + k / 2 - 1 < nums1.length
            ? nums1[startOfNums1 + k / 2 - 1]
            : Integer.MAX_VALUE;
        
        int halfKthOfNums2 = startOfNums2 + k / 2 - 1 < nums2.length
            ? nums2[startOfNums2 + k / 2 - 1]
            : Integer.MAX_VALUE;
        
        if (halfKthOfNums1 < halfKthOfNums2) {
            return findKth(nums1, startOfNums1 + k / 2, 
                           nums2, startOfNums2, 
                           k - k / 2);
        } else {
            return findKth(nums1, startOfNums1, 
                           nums2, startOfNums2 + k / 2, 
                           k - k / 2);
        }
    }
}