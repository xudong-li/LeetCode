class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> result = new LinkedList<int[]>();
        
        //1. add all intervals starting before the newInterval
        while (idx < n && newStart > intervals[idx][0]) {
            result.add(intervals[idx++]);
        }
        
        // add newInterval
        int[] interval = new int[2];
        // if there is no overlap, just add the interval
        if (result.isEmpty() || result.getLast()[1] < newStart) {
            result.add(newInterval);
        }
        // if there is an overlap
        else {
            result.getLast()[1] = Math.max(result.getLast()[1], newEnd);
        }
        
        // add the rest of the intervals, merge them if needed
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            if (result.getLast()[1] < start) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], end);
            }
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}