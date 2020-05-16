import java.util.*;

class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    // TODO: Write your code here
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegrees = new HashMap<>();

    for (int i = 0; i < vertices; i++) {
      graph.put(i, new ArrayList<Integer>());
      inDegrees.put(i, 0);
    }

    for (int i = 0; i < edges.length; i++) {
      int parent = edges[i][0], child = edges[i][1];
      graph.get(parent).add(child);
      inDegrees.put(child, inDegrees.get(child) + 1);
    }

    Queue<Integer> q = new LinkedList<>();
    for (Map.Entry<Integer,Integer> entry : inDegrees.entrySet()) {
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

    if (sortedOrder.size() != vertices) {
      return new ArrayList<Integer>();
    }

    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = TopologicalSort.sort(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
        new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}