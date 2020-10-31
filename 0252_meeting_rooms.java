class IntervalComparator implements Comparator<int[]> {
    public int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0];
    }
}

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, new IntervalComparator());
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                return false;
            }
            start = intervals[i][0];
            end = intervals[i][1];
        }
        
        return true;
    }
}