class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[right], height[left]) * (right - left);
            result = Math.max(result, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
}