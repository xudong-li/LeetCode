class HitCounter {

    // Map<time, hits>
    private Map<Integer, Integer> map;
    
    // queue of time
    private Queue<Integer> queue;
    
    private int totalHits = 0;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<Integer,Integer>();
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp) + 1);
        } else {
            map.put(timestamp, 1);
            queue.add(timestamp);
        }
        totalHits++;
        
        while (!queue.isEmpty() && timestamp - 300 >= queue.peek()) {
            int timestampToRemove = queue.poll();
            totalHits -= map.get(timestampToRemove);
            map.remove(timestampToRemove);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - 300 >= queue.peek()) {
            int timestampToRemove = queue.poll();
            totalHits -= map.get(timestampToRemove);
            map.remove(timestampToRemove);
        }
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */