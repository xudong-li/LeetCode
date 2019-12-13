import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    // TODO: Write your code here
    Map<Character, Integer> patternFreqMap = new HashMap<Character, Integer>();
    for (char c : pattern.toCharArray()) {
      patternFreqMap.put(c, patternFreqMap.getOrDefault(c, 0) + 1);
    }

    int windowStart = 0;
    int matched = 0;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (patternFreqMap.containsKey(rightChar)) {
        patternFreqMap.put(rightChar, patternFreqMap.get(rightChar) - 1);
        if (patternFreqMap.get(rightChar) == 0) {
          matched++;
        }
      }

      if (matched == patternFreqMap.size()) {
        resultIndices.add(windowStart);
      }

      if (windowEnd >= pattern.length() - 1) {
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
    return resultIndices;
  }
}












