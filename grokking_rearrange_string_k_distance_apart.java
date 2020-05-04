import java.util.*;

class RearrangeStringKDistanceApart {

  public static String reorganizeString(String str, int k) {
    // TODO: Write your code here
    // 1. count character frequency
    Map<Character, Integer> charFreq = new HashMap<Character, Integer>();
    for (char c : str.toCharArray()) {
        charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
    }

    // 2. using a maxHeap to get the most frequent characters
    PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> (e2.getValue() - e1.getValue()));
    maxHeap.addAll(charFreq.entrySet());

    // 3. take entries out of maxHeap, and start to arrange them
    StringBuilder sb = new StringBuilder();
    Queue<Map.Entry<Character,Integer>> q = new LinkedList<>();
    while (!maxHeap.isEmpty()) {
        Map.Entry<Character,Integer> currEntry = maxHeap.poll();
        sb.append(currEntry.getKey());
        currEntry.setValue(currEntry.getValue() - 1);
        q.add(currEntry);
        // if the queue size cannot reach k, and maxHeap is empty, we just return
        if (q.size() == k) {
            Map.Entry<Character,Integer> entry = q.poll();
            if (entry.getValue() > 0) {
                maxHeap.add(entry);
            }
        }
    } 
    return sb.length() == str.length() ? sb.toString() : "";
  }

  public static void main(String[] args) {
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
  }
}
