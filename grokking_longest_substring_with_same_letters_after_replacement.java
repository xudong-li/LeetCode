class CharacterReplacement {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    Map<Character, Integer> charFreqCount = new HashMap<>();
    int maxRepeatingCharCount = 0;
    int windowStart = 0;
    int result = 0;

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFreqCount.put(rightChar, charFreqCount.getOrDefault(rightChar, 0) + 1);
      maxRepeatingCharCount = Math.max(maxRepeatingCharCount, charFreqCount.get(rightChar));

      if (windowEnd - windowStart + 1 - maxRepeatingCharCount > k) {
        charFreqCount.put(str.charAt(windowStart), charFreqCount.get(str.charAt(windowStart)) - 1);
        windowStart++;
      }

      result = Math.max(result, windowEnd - windowStart + 1);
    }

    return result;
  }
}
