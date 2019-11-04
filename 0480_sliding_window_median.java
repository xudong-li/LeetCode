class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) {
            return new double[0];
        }
        
        double[] result = new double[n];
        
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        
        return result;
    }
    
    private void add(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        maxHeap.add(num);
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
    }
    
    private void remove(int num) {
        if (num > getMedian()) {
            minHeap.remove(num);
        } else {
            maxHeap.remove(num);
        }
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        
        return;
    }
    
    private double getMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
        }
        return (double)maxHeap.peek();
    }
}