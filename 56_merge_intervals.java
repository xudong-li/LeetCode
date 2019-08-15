class Interval{
    int begin, end;
    public Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
};

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        
        Collections.sort(intervalList, new IntervalComparator());
        List<Interval> resultInterval = new ArrayList<Interval>();
        
        Interval last = intervalList.get(0);
        
        for (int i = 1; i < intervalList.size(); i++) {
            Interval curr = intervalList.get(i);
            if (curr.begin <= last.end) {
                last.end = Math.max(curr.end, last.end);
            } else {
                resultInterval.add(last);
                last = curr;
            }
        }
        
        resultInterval.add(last);
        
        int[][] result = new int[resultInterval.size()][2];
        
        for (int i = 0; i < result.length; i++) {
            result[i][0] = resultInterval.get(i).begin;
            result[i][1] = resultInterval.get(i).end;
        }
        
        return result;
        
    }
    
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.begin - b.begin;
        }
    }
}