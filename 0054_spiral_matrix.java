class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        
        int left = 0, top = 0, right = n - 1, bot = m - 1;
        int count = m * n;
        while (count > 0) {
            int curr = left;
            while (count > 0 && curr <= right) {
                result.add(matrix[top][curr]);
                curr++;
                count--;
            }
            top++;
            curr = top;
            while (count > 0 && curr <= bot) {
                result.add(matrix[curr][right]);
                curr++;
                count--;
            }
            right--;
            curr = right;
            while (count > 0 && curr >= left) {
                result.add(matrix[bot][curr]);
                curr--;
                count--;
            }
            bot--;
            curr = bot;
            while (count > 0 && curr >= top) {
                result.add(matrix[curr][left]);
                curr--;
                count--;
            }
            left++;
        }
        
        return result;
    }
}