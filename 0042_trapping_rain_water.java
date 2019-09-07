class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        
        
        int result = 0;
        if (left >= right) {
            return result;
        }
        
        int leftHeight = height[left], rightHeight = height[right];
        
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > height[left]) {
                    result += (leftHeight - height[left]);
                } else {
                    leftHeight = height[left];    
                }
            } else {
                right--;
                if (rightHeight > height[right]) {
                    result += (rightHeight - height[right]);
                } else {
                    rightHeight = height[right];
                }
            }
        }
        
        return result;
    }
}