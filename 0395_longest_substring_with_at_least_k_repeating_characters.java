class Solution {
    public int longestSubstring(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] counter = new int[26];
        // count occurance of all chars
        for (char c : charArray) {
            counter[c - 'a']++;
        }
        
        // check if the whole string is valid
        boolean fullValid = true;
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0 && counter[i] < k) {
                fullValid = false;
                break;
            }
        }
        
        if (fullValid) {
            return s.length();
        }
        
        // using recursion. 
        // if a char is less than k, then the result is either left or right
        int windowStart = 0;
        int result = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (counter[s.charAt(windowEnd) - 'a'] > 0 && counter[s.charAt(windowEnd) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(windowStart, windowEnd), k));
                windowStart = windowEnd + 1;
            }
        }
        
        result = Math.max(result, longestSubstring(s.substring(windowStart, s.length()), k));
        return result;
    }
}