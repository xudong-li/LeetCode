import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    // TODO: Write your code here
    int windowStart = 0;
    int result = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      if (charIndexMap.containsKey(str.charAt(windowEnd))) {
        // This is tricky, the windowStart cannot go backwards.
        // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
        windowStart = Math.max(windowStart, charIndexMap.get(str.charAt(windowEnd)) + 1);
      }
      charIndexMap.put(str.charAt(windowEnd), windowEnd);
      result = Math.max(result, windowEnd - windowStart + 1);
    }
    return result;
  }
}
