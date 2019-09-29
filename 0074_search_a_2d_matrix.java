class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int top = 0, bot = matrix.length - 1;
        
        while (top + 1 < bot) {
            int midRow = (top + bot) / 2;
            if (matrix[midRow][0] >= target) {
                bot = midRow;
            } else {
                top = midRow;
            }
        }
        
        int row;
        if (target < matrix[bot][0]) {
            row = top;
        } else {
            row = bot;
        }
        
        int left = 0, right = matrix[0].length - 1;
        
        while (left + 1 < right) {
            int midIndex = (left + right) / 2;
            if (matrix[row][midIndex] == target) {
                return true;
            }
            if (matrix[row][midIndex] < target) {
                left = midIndex;
            } else {
                right = midIndex;
            }
        }
        
        if (matrix[row][left] == target) {
            return true;
        }
        if (matrix[row][right] == target) {
            return true;
        }
        
        return false;
    }
}