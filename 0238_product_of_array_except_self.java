class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productToLeft = new int[nums.length];
        int[] productToRight = new int[nums.length];
        
        productToLeft[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productToLeft[i] = productToLeft[i - 1] * nums[i - 1];
        }
        
        productToRight[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            productToRight[i] = productToRight[i + 1] * nums[i + 1];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = productToLeft[i] * productToRight[i];
        }
        
        return result;
    }
}