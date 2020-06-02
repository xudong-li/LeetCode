class Node {
    int value;
    boolean isStart;
    public Node(int value, boolean isStart) {
        this.value = value;
        this.isStart = isStart;
    }
}

class TimelineComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        if (n1.value == n2.value) {
            if (n1.isStart && n2.isStart) {
                return 0;
            } else if (!n1.isStart && n2.isStart){
                return -1;
            } else if (n1.isStart && !n2.isStart) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return n1.value - n2.value;
        }
    }
}
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Node> timeline = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            timeline.add(new Node(intervals[i][0], true));
            timeline.add(new Node(intervals[i][1], false));
        }
        
        Collections.sort(timeline, new TimelineComparator());
        
        int maxRooms = 0;
        int currRooms = 0;
        for (int i = 0; i < timeline.size(); i++) {
            if (timeline.get(i).isStart) {
                currRooms++;
            } else {
                currRooms--;
            }
            maxRooms = Math.max(maxRooms, currRooms);
        }
        
        return maxRooms;
    }
}