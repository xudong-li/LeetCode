import java.util.*;

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class Node {
  int time;
  boolean isStart;

  public Node(int time, boolean isStart) {
    this.time = time;
    this.isStart = isStart;
  }
}

class MinimumMeetingRooms {

  static Comparator<Node> nodeComparebyTime = new Comparator<Node>() {
      @Override
      public int compare(Node a, Node b) {
          if (a.time != b.time) {
            return Integer.compare(a.time, b.time);
          }
          return Boolean.compare(a.isStart, b.isStart);
      }
  };

  public static int findMinimumMeetingRooms(List<Meeting> meetings) {
    // TODO: Write your code here
    List<Node> meetingNodes = new ArrayList<>();
    for (Meeting meeting : meetings) {
      meetingNodes.add(new Node(meeting.start, true));
      meetingNodes.add(new Node(meeting.end, false));
    }


    Collections.sort(meetingNodes, nodeComparebyTime);

    int result = 0;
    int meetingRooms = 0;
    for (Node n : meetingNodes) {
      if (n.isStart) {
        meetingRooms++;
      } else {
        meetingRooms--;
      }
      result = Math.max(result,meetingRooms);
    }

    return result;
  }

  public static void main(String[] args) {
    List<Meeting> input = new ArrayList<Meeting>() {
      {
        add(new Meeting(4, 5));
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
      }
    };
    int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 5));
        add(new Meeting(7, 9));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(6, 7));
        add(new Meeting(2, 4));
        add(new Meeting(8, 12));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 3));
        add(new Meeting(3, 6));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(4, 5));
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);
  }
}
