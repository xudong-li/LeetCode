import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> mergedIntervals = new ArrayList<>();
    //TODO: Write your code here
    int i = 0;

    // skip all intervals that has end less than the new newinterval start
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      mergedIntervals.add(intervals.get(i));
      i++;
    }

    // merge all overlapping intervals
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }

    // add to the result
    mergedIntervals.add(newInterval);

    // add the remaining intervals to the result
    while (i < intervals.size()) {
      mergedIntervals.add(intervals.get(i++));
    }

    return mergedIntervals;
  }

  public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
