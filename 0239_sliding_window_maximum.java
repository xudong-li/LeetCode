class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        
        int maxIndex = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < k; i++) {
            removeNonMaxIndexes(deque, nums, i, k);
            deque.addLast(i);
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        int result[] = new int[n - k + 1];
        result[0] = nums[maxIndex];
        
        for (int i = k; i < n; i++) {
            removeNonMaxIndexes(deque, nums, i, k);
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        
        return result;
    }
    
    private void removeNonMaxIndexes(Deque<Integer> deque, int[] nums, int i, int k) {
        // remove the indexes that is not in the sliding window
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        
        // remove the indexes that is smaller than the next number
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }
    
}