/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        
        int left = 0, right = cols - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (containsOne(binaryMatrix, mid, rows)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (containsOne(binaryMatrix, left, rows)) {
            return left;
        }
        if (containsOne(binaryMatrix, right, rows)) {
            return right;
        }
        
        return -1;
    }
    
    private boolean containsOne(BinaryMatrix binaryMatrix, int mid, int rows) {
        for (int i = 0; i < rows; i++) {
            if (binaryMatrix.get(i, mid) == 1) {
                return true;
            }
        }
        return false;
    }
}