import java.util.*;

class FrequencySort {

  public static String sortCharacterByFrequency(String str) {
    // TODO: Write your code here
    Map<Character, Integer> countFreq = new HashMap<Character, Integer>();
    for (char c : str.toCharArray()) {
      countFreq.put(c, countFreq.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
      (e1, e2) -> (e2.getValue() - e1.getValue()));

    for (Map.Entry<Character, Integer> entry : countFreq.entrySet()) {
      maxHeap.add(entry);
    }

    StringBuilder sb = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> entry = maxHeap.poll();
      for (int i = 0; i < entry.getValue(); i++) {
        sb.append(entry.getKey());
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
  }
}
