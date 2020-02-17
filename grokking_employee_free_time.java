import java.util.*;


class Node {
  int time;
  boolean isStart;

  public Node(int time, boolean isStart) {
    this.time = time;
    this.isStart = isStart;
  }
};

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class EmployeeFreeTime {

  static Comparator<Node> sortByStartTime = new Comparator<Node>() {
    @Override
    public int compare(Node a, Node b) {
      if (a.time != b.time) {
        return Integer.compare(a.time, b.time);
      }
      return Boolean.compare(a.isStart, b.isStart);
    }
  };

  public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> result = new ArrayList<>();
    // TODO: Write your code here
    List<Node> timeline = new ArrayList<>();
    for (List<Interval> list : schedule) {
      for (Interval interval : list) {
        timeline.add(new Node(interval.start, true));
        timeline.add(new Node(interval.end, false));
      }
    }

    Collections.sort(timeline, sortByStartTime);

    int count = 0;
    int freeTimeStart = -1;
    int freeTimeEnd = -1;
    for (int i = 0; i < timeline.size(); i++) {
      if (timeline.get(i).isStart) {
        count++;
      } else {
        count--;
      }

      if (i > 0 && count == 0 && freeTimeStart == -1) {
        freeTimeStart = timeline.get(i).time;
      } else if (freeTimeStart != -1 && count > 0) {
        freeTimeEnd = timeline.get(i).time;
        if (freeTimeEnd != freeTimeStart)
          result.add(new Interval(freeTimeStart, freeTimeEnd));
        freeTimeStart = -1;
      }
    }
    return result;
  }

  public static void main(String[] args) {

    List<List<Interval>> input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
    List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
    result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
    result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
  }
}
