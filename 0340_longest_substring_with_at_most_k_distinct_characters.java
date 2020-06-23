class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        int countDistinct = 0;
        int result = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char curr = s.charAt(windowEnd);
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
                countDistinct++;
            } else {
                map.put(curr, map.get(curr) + 1);
            }
            
            if (countDistinct <= k) {
                result = Math.max(result, windowEnd - windowStart + 1);
            }
            
            char charAtWindowStart = s.charAt(windowStart);
            if (countDistinct > k) {
                map.put(charAtWindowStart, map.get(charAtWindowStart) - 1);
                if (map.get(charAtWindowStart) == 0) {
                    map.remove(charAtWindowStart);
                    countDistinct--;
                }
                windowStart++;
            }
        }
        
        return result;
    }
}