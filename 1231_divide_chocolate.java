class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        // using binary search to search for the sweetness that we want to cut
        int low = 1;
        int high = Arrays.stream(sweetness).sum() / (K + 1);
        
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canSplit(sweetness, K, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    private boolean canSplit(int[] sweetness, int k, int mid) {
        int sum = 0;
        int chunk = 0;
        for (int s : sweetness) {
            sum += s;
            if (sum >= mid) {
                chunk++;
                sum = 0;
            }
        }
        
        return chunk >= k + 1;
    }
}