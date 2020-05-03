import java.util.*;

class MaximumDistinctElements {

  public static int findMaximumDistinctElements(int[] nums, int k) {
    // TODO: Write your code here
    // 1. count occurance
    Map<Integer, Integer> countFreq = new HashMap<>();
    for (int num : nums) {
      countFreq.put(num, countFreq.getOrDefault(num, 0) + 1);
    }

    // 2. sort them in a minHeap;
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
    minHeap.addAll(countFreq.entrySet());

    // 3. remove from heap
    int result = 0;
    while (k > 0 && !minHeap.isEmpty()) {
      int occurance = minHeap.poll().getValue();
      if (occurance == 1) {
        result++;
      } else {
        if (occurance - k >= 1) {
          result++;
          k = k - (occurance - 1);
        }
      }
    }

    if (k > 0 && minHeap.isEmpty()) {
      result--;
      k--;
    }
    return result;
  }

  public static void main(String[] args) {
    int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);
  }
}