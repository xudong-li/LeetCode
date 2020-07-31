class MovingAverage {

    private Deque<Integer> deque;
    private int sum;
    private int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        deque = new LinkedList<>();
        this.sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        deque.add(val);
        sum += val;
        
        double result = 0.0;
        
        if (deque.size() > this.size) {
            sum -= deque.pollFirst();
        }
        
        return (double) sum / deque.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */