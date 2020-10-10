class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0, bot = n - 1, left = 0, right = n - 1;
        int num = 1;
        int[][] result = new int[n][n];
        
        while (num <= n * n) {
            int curr = left;
            while (num <= n * n && curr <= right) {
                result[top][curr] = num;
                num++;
                curr++;
            }
            top++;
            
            curr = top;
            while (num <= n * n && curr <= bot) {
                result[curr][right] = num;
                num++;
                curr++;
            }
            right--;
            
            curr = right;
            while (num <= n * n && curr >= left) {
                result[bot][curr] = num;
                num++;
                curr--;
            }
            bot--;
            
            curr = bot;
            while (num <= n * n && curr >= top) {
                result[curr][left] = num;
                num++;
                curr--;
            }
            left++;
        }
        
        return result;
    }
}