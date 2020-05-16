import java.util.*;

class TaskScheduling {
  public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
    // TODO: Write your code here
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegrees = new HashMap<>();

    for (int i = 0; i < tasks; i++) {
      graph.put(i, new ArrayList<Integer>());
      inDegrees.put(i, 0);
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int parent = prerequisites[i][0], child = prerequisites[i][1];
      graph.get(parent).add(child);
      inDegrees.put(child, inDegrees.get(child) + 1);
    }    

    List<Integer> sortedOrder = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();

    for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
      if (entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    while (!q.isEmpty()) {
      int currNode = q.poll();
      sortedOrder.add(currNode);
      List<Integer> children = graph.get(currNode);
      for (int i = 0; i < children.size(); i++) {
        inDegrees.put(children.get(i), inDegrees.get(children.get(i)) - 1);
        if (inDegrees.get(children.get(i)) == 0) {
          q.add(children.get(i));
        }
      }
    }

    if (sortedOrder.size() == tasks) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {

    boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
    System.out.println("Tasks execution possible: " + result);

    result = TaskScheduling.isSchedulingPossible(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
    System.out.println("Tasks execution possible: " + result);

    result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
        new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    System.out.println("Tasks execution possible: " + result);
  }
}