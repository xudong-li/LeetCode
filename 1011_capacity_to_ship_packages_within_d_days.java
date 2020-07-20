class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int low = 1;
        int high = Arrays.stream(weights).sum();
        while (low < high) {
            int mid = (low + high) / 2;
            if (canLoad(weights, D, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean canLoad(int[] weights, int D, int capacity) {
        int sum = 0;
        int days = 1;
        for (int w : weights) {
            if (w > capacity || days > D) return false;
            if (sum + w > capacity) {
                sum = w;
                days++;
            } else {
                sum += w;
            }
        }
        
        return days <= D;
    }
}