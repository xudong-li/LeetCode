class Solution {

    private int totalWeights = 0;
    private int[] prefixSums;
    
    public Solution(int[] w) {
        prefixSums = new int[w.length];
        int currSum = 0;
        for (int i = 0; i < w.length; i++) {
            currSum += w[i];
            this.prefixSums[i] = currSum;
        }
        this.totalWeights = currSum;
    }
    
    public int pickIndex() {
        int left = 0, right = prefixSums.length;
        double target = totalWeights * Math.random();
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (prefixSums[left] > target) {
            return left;
        }
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */