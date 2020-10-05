class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        // for each point in the matrix, we have height, left and right array
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(right, n);
        
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            // height
            int curr_left = 0;
            int curr_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            
            //left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curr_left);
                } else {
                    left[j] = 0;
                    curr_left = j + 1;
                }
            }
            
            //right
            for (int j = n - 1;j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curr_right);
                } else {
                    right[j] = n;
                    curr_right = j;
                }
            }
            
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        
        return maxArea;
    }
}