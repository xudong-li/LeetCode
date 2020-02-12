import java.util.*;

class Job {
  int start;
  int end;
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class Node {
  int cpuLoad;
  int time;
  boolean isStart;

  public Node (int cpuLoad, int time, boolean isStart) {
    this.cpuLoad = cpuLoad;
    this.time = time;
    this.isStart = isStart;
  }
};

class MaximumCPULoad {

  static Comparator<Node> compareNode = new Comparator<Node>() {
    @Override
    public int compare(Node a, Node b) {
      if (a.time != b.time) {
        return Integer.compare(a.time, b.time);
      }
      return Boolean.compare(a.isStart, b.isStart);
    }
  };
  public static int findMaxCPULoad(List<Job> jobs) {
    // TODO: Write your code here
    List<Node> cpuNodeList = new ArrayList<>();

    for (Job job : jobs) {
      cpuNodeList.add(new Node(job.cpuLoad, job.start, true));
      cpuNodeList.add(new Node(job.cpuLoad, job.end, false));
    }

    Collections.sort(cpuNodeList, compareNode);

    int maxCpuLoad = 0;
    int currCpuLoad = 0;
    for (Node node : cpuNodeList) {
      if (node.isStart) {
        currCpuLoad += node.cpuLoad;
      } else {
        currCpuLoad -= node.cpuLoad;
      }
      maxCpuLoad = Math.max(maxCpuLoad, currCpuLoad);
    }

    return maxCpuLoad;
  }

  public static void main(String[] args) {
    List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
  }
}
