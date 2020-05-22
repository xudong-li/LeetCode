import java.util.*;

class AlienDictionary {
  public static String findOrder(String[] words) {
    // TODO: Write your code here
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> inDegrees = new HashMap<>();

    for (String s : words) {
      for (Character c : s.toCharArray()) {
        graph.put(c, new ArrayList<>());
        inDegrees.put(c, 0);
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      String parent = words[i], child = words[i + 1];
      for (int j = 0; j < Math.min(parent.length(), child.length()); j++) {
        // if the character between the two adjacent words are not the same, 
        // then we can find the order
        if (parent.charAt(j) != child.charAt(j)) {
          graph.get(parent.charAt(j)).add(child.charAt(j));
          inDegrees.put(child.charAt(j), inDegrees.get(child.charAt(j)) + 1);
          break;
        }
      }
    }

    StringBuilder result = new StringBuilder();
    Queue<Character> q = new LinkedList<>();

    for (Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
      if (entry.getValue() == 0) {
        q.offer(entry.getKey());
      }
    }

    while (!q.isEmpty()) {
      Character currNode = q.poll();
      result.append(currNode);
      List<Character> children = graph.get(currNode);
      for (int i = 0; i < children.size(); i++) {
        inDegrees.put(children.get(i), inDegrees.get(children.get(i)) - 1);
        if (inDegrees.get(children.get(i)) == 0) {
          q.offer(children.get(i));
        }
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
    System.out.println("Character order: " + result);
  }
}