import java.util.*;

class TopKFrequentNumbers {

  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topNumbers = new ArrayList<>(k);
    // TODO: Write your code here
    Map<Integer,Integer> countFreq = new HashMap<Integer,Integer>();
    for (int num : nums) {
      countFreq.put(num, countFreq.getOrDefault(num, 0) + 1);
    }
    
    PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>(
      (e1, e2) -> e1.getValue() - e2.getValue());

    for (Map.Entry<Integer, Integer> e : countFreq.entrySet()) {
      minHeap.add(e);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    while (!minHeap.isEmpty()) {
      topNumbers.add(minHeap.poll().getKey());
    }

    return topNumbers;
  }

  public static void main(String[] args) {
    List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}
