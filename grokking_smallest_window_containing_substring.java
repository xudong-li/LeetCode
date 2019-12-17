import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    // TODO: Write your code here
    Map<Character, Integer> patternFreqMap = new HashMap<>();
    for (char c : pattern.toCharArray()) {
      patternFreqMap.put(c, patternFreqMap.getOrDefault(c, 0) + 1);
    }

    int matched = 0;
    int resultLength = Integer.MAX_VALUE;
    int windowStart = 0;
    int subStringStart = 0;

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (patternFreqMap.containsKey(rightChar)) {
        patternFreqMap.put(rightChar, patternFreqMap.get(rightChar) - 1);
        if (patternFreqMap.get(rightChar) >= 0) {
          matched++;
        }
      }

      while (matched == pattern.length()) {
        if (resultLength > windowEnd - windowStart + 1) {
          resultLength = windowEnd - windowStart + 1;
          subStringStart = windowStart;
        }

        char leftChar = str.charAt(windowStart);
        windowStart++;

        if (patternFreqMap.containsKey(leftChar)) {
          if (patternFreqMap.get(leftChar) == 0) {
            matched--;
          }
          patternFreqMap.put(leftChar, patternFreqMap.get(leftChar) + 1);
        }
      }

    }
    return resultLength > str.length() ? "" : str.substring(subStringStart, subStringStart + resultLength);
  }
}




