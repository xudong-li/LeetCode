import java.util.*;

class TaskScheduler {

  public static int scheduleTasks(char[] tasks, int k) {
    // TODO: Write your code here
    // 1. count the occurance of all tasks
    Map<Character,Integer> countFreq = new HashMap<Character,Integer>();
    for (char c : tasks) {
      countFreq.put(c, countFreq.getOrDefault(c, 0) + 1);
    }

    // 2. use a max heap sort the occurance
    PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
    maxHeap.addAll(countFreq.entrySet());

    // 3. start to empty the maxHeap with a greedy approach
    int result = 0;
    while (!maxHeap.isEmpty()) {
      List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
      int n = k + 1; // try to execute as many as 'k+1' tasks from the max-heap
      for (; n > 0 && !maxHeap.isEmpty(); n--) {
        result++;
        Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
        if (currentEntry.getValue() > 1) {
          currentEntry.setValue(currentEntry.getValue() - 1);
          waitList.add(currentEntry);
        }
      }
      maxHeap.addAll(waitList); // put all the waiting list back on the heap
      if (!maxHeap.isEmpty())
        result += n; // we'll be having 'n' idle intervals for the next iteration
    }
    return result;
  }

  public static void main(String[] args) {
    char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

    tasks = new char[] { 'a', 'b', 'a' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
  }
}
