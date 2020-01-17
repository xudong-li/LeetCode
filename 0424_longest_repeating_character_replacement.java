class Solution {
    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int maxCount = 0;
        int result = 0;
        Map<Character, Integer> letterCountMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char endChar = s.charAt(windowEnd);
            letterCountMap.put(endChar, letterCountMap.getOrDefault(endChar, 0) + 1);
            maxCount = Math.max(maxCount, letterCountMap.get(endChar));
            
            while (windowEnd - windowStart + 1 - maxCount > k) {
                char startChar = s.charAt(windowStart);
                letterCountMap.put(startChar, letterCountMap.get(startChar) - 1);
                windowStart++;
            }
            
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        
        return result;
    }
}