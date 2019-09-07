class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
                result = Math.max(result, j - i + 1);
                j++;
            }
            map.remove(s.charAt(i));
        }
        
        return result;
    }
}