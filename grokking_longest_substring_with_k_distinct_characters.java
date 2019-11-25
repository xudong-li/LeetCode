import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    Map<Character, Integer> counter = new HashMap<>();
    int distinct = 0;
    int result = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      if (counter.containsKey(str.charAt(windowEnd))) {
        counter.put(str.charAt(windowEnd), counter.get(str.charAt(windowEnd)) + 1);
      } else {
        distinct++;
        counter.put(str.charAt(windowEnd), 1);
        while (distinct > k) {
          counter.put(str.charAt(windowStart), counter.get(str.charAt(windowStart)) - 1);
          if (counter.get(str.charAt(windowStart)) == 0) {
            counter.remove(str.charAt(windowStart));
            distinct--;
          }
          windowStart++;
        }
      }
      result = Math.max(result, windowEnd - windowStart + 1);
    }
    return result;
  }
}
